package com.elice.gameservice.domain.room.store

import com.elice.gameservice.domain.room.model.Room

interface RoomStore {
    fun saveRoom(room: Room): Room
}