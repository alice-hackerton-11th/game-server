package com.elice.gameservice.domain.room.model

import com.elice.gameservice.domain.common.value.RoomMemberProgressState
import com.elice.gameservice.domain.common.value.RoomMemberRole
import jakarta.persistence.*

@Entity
class RoomMemberInfo(
    @Enumerated(value = EnumType.STRING)
    val roomMemberRole: RoomMemberRole,
    var heart: Int,
    @Enumerated(value = EnumType.STRING)
    var roomMemberProgressState: RoomMemberProgressState = RoomMemberProgressState.IN_PROGRESS
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_member_info_id")
    var id: Long? = null
}