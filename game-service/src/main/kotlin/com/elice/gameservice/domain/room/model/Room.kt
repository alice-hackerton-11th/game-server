package com.elice.gameservice.domain.room.model

import com.elice.gameservice.domain.common.model.BaseModel
import com.elice.gameservice.domain.common.value.RoomMemberEnteredState
import jakarta.persistence.*

@Entity
class Room(
    var subject: String,
    var memberLimit: Int,
    var explanationSecond: Long
) : BaseModel() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    var id: Long? = null

    @OneToMany(mappedBy = "room", cascade = [CascadeType.PERSIST])
    var roomMemberList: MutableList<RoomMember> = ArrayList()

    fun createRoomMember(memberId: Long) {
        val roomMember = RoomMember(this, memberId)
        roomMember.roomMemberEnteredState = RoomMemberEnteredState.ENTERED
        roomMemberList.add(roomMember)
    }
}