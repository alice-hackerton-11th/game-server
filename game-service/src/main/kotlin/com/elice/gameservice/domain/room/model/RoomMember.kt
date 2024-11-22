package com.elice.gameservice.domain.room.model

import com.elice.gameservice.domain.common.model.BaseModel
import com.elice.gameservice.domain.common.value.RoomMemberEnteredState
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
}