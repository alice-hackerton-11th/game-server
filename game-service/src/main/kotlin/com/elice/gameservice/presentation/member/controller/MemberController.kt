package com.elice.gameservice.presentation.member.controller

import com.elice.common.response.BaseResponse
import com.elice.common.token.TokenProvider
import com.elice.gameservice.presentation.member.dto.RegisterMemberRequestDto
import com.elice.gameservice.presentation.member.dto.RegisterMemberResponseDto
import com.elice.gameservice.application.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService,
    private val tokenProvider: TokenProvider
) {
    @PostMapping("/member")
    fun registerMemberIfNot(@RequestBody @Valid request: RegisterMemberRequestDto): BaseResponse<RegisterMemberResponseDto> {
        val member = memberService.registerMemberIfNot(request.name)
        val accessToken = tokenProvider.createAccessToken(member.id!!)
        return BaseResponse(RegisterMemberResponseDto(member.id!!, accessToken))
    }
}