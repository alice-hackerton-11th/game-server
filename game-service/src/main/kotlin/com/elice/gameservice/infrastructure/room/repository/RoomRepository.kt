package com.elice.gameservice.infrastructure.room.repository

import com.elice.gameservice.domain.room.model.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : JpaRepository<Room, Long> {
}