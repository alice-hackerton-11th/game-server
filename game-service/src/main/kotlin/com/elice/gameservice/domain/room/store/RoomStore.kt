package com.elice.gameservice.domain.room.store

import com.elice.gameservice.domain.member.model.Member
import com.elice.gameservice.domain.room.model.Room
import com.elice.gameservice.domain.room.model.RoomMember
import com.elice.gameservice.domain.room.model.Topic

interface RoomStore {
    fun saveRoom(room: Room): Room
    fun findRoomById(roomId: Long): Room?
    fun findRoomMember(roomId: Long, memberId: Long): RoomMember?
    fun findAllRoom(page: Int, size: Int): List<Room>
    fun countAllRoom(): Long
    fun findAllRoomMember(room: Room): List<RoomMember>
    fun findAllMemberInRoom(room: Room): List<Member>
    fun getTopicList(): List<Topic>
}