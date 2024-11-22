package com.elice.gameservice.infrastructure.room.repository

import com.elice.gameservice.domain.common.enums.DeleteState
import com.elice.gameservice.domain.room.model.Room
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : JpaRepository<Room, Long> {
    fun findRoomById(roomId: Long): Room?
    fun findAllRoomByDeleteStateOrderByCreatedAtDesc(deleteState: DeleteState, pageable: Pageable): List<Room>
    fun countAllRoomByDeleteState(deleteState: DeleteState): Long
}