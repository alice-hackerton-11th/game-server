package com.elice.gameservice.domain.member.model

import com.elice.gameservice.domain.common.model.BaseModel
import jakarta.persistence.*

@Entity
class Member(
    val name: String
) : BaseModel() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    var id: Long? = null

    companion object {
        fun createMember(name: String): Member {
            return Member(name = name)
        }
    }
}