package com.elice.gameservice.domain.room.model

import com.elice.common.exception.ConflictException
import com.elice.common.response.BaseResponseStatus
import com.elice.gameservice.domain.common.enums.DeleteState
import com.elice.gameservice.domain.common.model.BaseModel
import com.elice.gameservice.domain.room.enums.RoomMemberEnteredState
import jakarta.persistence.*

@Entity
class RoomMember(
    @ManyToOne
    @JoinColumn(name = "room_id")
    val room: Room,
    val memberId: Long
) : BaseModel() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_member_id")
    var id: Long? = null

    @Enumerated(value = EnumType.STRING)
    var roomMemberEnteredState: RoomMemberEnteredState = RoomMemberEnteredState.NOT_ENTERED

    fun enterRoom() {
        roomMemberEnteredState = RoomMemberEnteredState.ENTERED
        room.memberCount++
        if (room.memberCount > room.memberLimit) {
            throw ConflictException(BaseResponseStatus.EXCEED_MEMBER_LIMIT)
        }
    }

    fun exitRoom() {
        roomMemberEnteredState = RoomMemberEnteredState.NOT_ENTERED
        room.memberCount--
        if (room.memberCount <= 0) {
            room.deleteState = DeleteState.DELETED
        }
    }
}