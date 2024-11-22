package com.elice.gameservice.infrastructure.room.store

import com.elice.gameservice.domain.common.enums.DeleteState
import com.elice.gameservice.domain.room.model.Room
import com.elice.gameservice.domain.room.model.RoomMember
import com.elice.gameservice.domain.room.store.RoomStore
import com.elice.gameservice.infrastructure.room.repository.RoomMemberRepository
import com.elice.gameservice.infrastructure.room.repository.RoomRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class RoomStoreImpl(
    private val roomRepository: RoomRepository,
    private val roomMemberRepository: RoomMemberRepository
) : RoomStore {
    override fun saveRoom(room: Room): Room {
        return roomRepository.save(room)
    }

    override fun findRoomById(roomId: Long): Room? {
        return roomRepository.findRoomById(roomId)
    }

    override fun findRoomMember(roomId: Long, memberId: Long): RoomMember? {
        return roomMemberRepository.findRoomMemberByRoomIdAndMemberId(roomId, memberId)
    }

    override fun findAllRoom(page: Int, size: Int): List<Room> {
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"))
        return roomRepository.findAllRoomByDeleteStateOrderByCreatedAtDesc(DeleteState.NOT_DELETED, pageable)
    }

    override fun countAllRoom(): Long {
        return roomRepository.countAllRoomByDeleteState(DeleteState.NOT_DELETED)
    }
}