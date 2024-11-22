package com.elice.gameservice.domain.room.store

import com.elice.gameservice.domain.room.model.Room
import com.elice.gameservice.domain.room.model.RoomMember

interface RoomStore {
    fun saveRoom(room: Room): Room
    fun findRoomById(roomId: Long): Room?
    fun findRoomMember(roomId: Long, memberId: Long): RoomMember?
    fun findAllRoom(page: Int, size: Int): List<Room>
    fun countAllRoom(): Long
}