package com.elice.gameservice.application.member.service

import com.elice.gameservice.domain.member.model.Member
import com.elice.gameservice.domain.member.store.MemberStore
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberStore: MemberStore,
) {
    @Transactional
    fun registerMemberIfNot(name: String): Member {
        return memberStore.findMemberByName(name) ?: run {
            val member = Member.createMember(name)
            memberStore.saveMember(member)
            member
        }
    }
}