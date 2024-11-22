package com.elice.gameservice.infrastructure.member.repository

import com.elice.gameservice.domain.member.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findByName(name: String): Member?
}