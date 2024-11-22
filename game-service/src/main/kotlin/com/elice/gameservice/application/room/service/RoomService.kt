package com.elice.gameservice.application.room.service

import com.elice.gameservice.domain.room.model.Room
import com.elice.gameservice.domain.room.store.RoomStore
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class RoomService(
    private val roomStore: RoomStore
) {
    @Transactional
    fun createRoom(subject: String, memberLimit: Int, explanationSecond: Long, memberId: Long) {
        val room = Room(subject = subject, memberLimit = memberLimit, explanationSecond = explanationSecond)
        room.addRoomMember(memberId)
        roomStore.saveRoom(room)
    }
}