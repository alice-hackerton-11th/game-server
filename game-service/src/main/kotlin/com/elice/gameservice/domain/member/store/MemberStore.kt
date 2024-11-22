package com.elice.gameservice.domain.member.store

import com.elice.gameservice.domain.member.model.Member

interface MemberStore {
    fun saveMember(member: Member): Member
    fun findMemberByName(name: String): Member?
}