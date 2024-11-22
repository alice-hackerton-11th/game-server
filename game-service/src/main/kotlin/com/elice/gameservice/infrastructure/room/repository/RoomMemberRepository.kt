package com.elice.gameservice.infrastructure.room.repository

import com.elice.gameservice.domain.member.model.Member
import com.elice.gameservice.domain.room.enums.RoomMemberEnteredState
import com.elice.gameservice.domain.room.model.Room
import com.elice.gameservice.domain.room.model.RoomMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RoomMemberRepository : JpaRepository<RoomMember, Long> {
    @Query(
        "SELECT rm FROM RoomMember rm " +
                "WHERE rm.room.id = :roomId AND rm.memberId =:memberId AND rm.room.deleteState = 'NOT_DELTED' "
    )
    fun findRoomMemberByRoomIdAndMemberId(roomId: Long, memberId: Long): RoomMember?
    fun findAllRoomMemberByRoomAndRoomMemberEnteredState(
        room: Room,
        roomMemberEnteredState: RoomMemberEnteredState
    ): List<RoomMember>

    @Query(
        "SELECT m FROM RoomMember rm JOIN Member m ON rm.memberId = m.id " +
                "WHERE rm.room = :room AND rm.roomMemberEnteredState = 'ENTERED'"
    )
    fun findAllMemberInRoom(room: Room): List<Member>
}