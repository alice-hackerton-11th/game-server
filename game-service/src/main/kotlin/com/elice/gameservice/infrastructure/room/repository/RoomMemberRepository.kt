package com.elice.gameservice.infrastructure.room.repository

import com.elice.gameservice.domain.room.model.RoomMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RoomMemberRepository : JpaRepository<RoomMember, Long> {
    @Query("SELECT rm FROM RoomMember rm WHERE rm.room.id = :roomId AND rm.memberId =:memberId ")
    fun findRoomMemberByRoomIdAndMemberId(roomId: Long, memberId: Long): RoomMember?
}