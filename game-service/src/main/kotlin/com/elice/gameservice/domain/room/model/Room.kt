package com.elice.gameservice.domain.room.model

import com.elice.gameservice.domain.common.enums.DeleteState
import com.elice.gameservice.domain.common.model.BaseModel
import com.elice.gameservice.domain.room.enums.RoomMemberEnteredState
import com.elice.gameservice.domain.room.enums.RoomProgressState
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

    var memberCount: Long = 0

    @OneToMany(mappedBy = "room", cascade = [CascadeType.PERSIST])
    var roomMemberList: MutableList<RoomMember> = ArrayList()

    @Enumerated(EnumType.STRING)
    var deleteState: DeleteState = DeleteState.NOT_DELETED

    @Enumerated(value = EnumType.STRING)
    var roomProgressState: RoomProgressState = RoomProgressState.NOT_STARTED

    @Version
    var version: Long? = null

    fun createRoomMember(memberId: Long) {
        val roomMember = RoomMember(this, memberId)
        roomMember.roomMemberEnteredState = RoomMemberEnteredState.ENTERED
        roomMemberList.add(roomMember)
        memberCount++
    }
}