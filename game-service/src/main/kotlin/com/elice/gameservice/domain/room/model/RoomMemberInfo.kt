package com.elice.gameservice.domain.room.model

import com.elice.gameservice.domain.room.enums.RoomMemberRole
import jakarta.persistence.*

@Entity
class RoomMemberInfo(
    @Enumerated(value = EnumType.STRING)
    val roomMemberRole: RoomMemberRole,
    var heart: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_member_info_id")
    var id: Long? = null
}