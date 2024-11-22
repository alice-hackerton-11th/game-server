package com.elice.gameservice.infrastructure.room.store

import com.elice.gameservice.domain.room.model.Room
import com.elice.gameservice.domain.room.store.RoomStore
import com.elice.gameservice.infrastructure.room.repository.RoomRepository
import org.springframework.stereotype.Component

@Component
class RoomStoreImpl(
    private val roomRepository: RoomRepository
) : RoomStore {
    override fun saveRoom(room: Room): Room {
        return roomRepository.save(room)
    }
}