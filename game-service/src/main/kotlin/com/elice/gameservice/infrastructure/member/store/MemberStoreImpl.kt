package com.elice.gameservice.infrastructure.member.store

import com.elice.gameservice.domain.member.model.Member
import com.elice.gameservice.domain.member.store.MemberStore
import com.elice.gameservice.infrastructure.member.repository.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberStoreImpl(
    private val memberRepository: MemberRepository
) : MemberStore {
    override fun saveMember(member: Member): Member {
        return memberRepository.save(member)
    }

    override fun findMemberByName(name: String): Member? {
        return memberRepository.findByName(name)
    }
}