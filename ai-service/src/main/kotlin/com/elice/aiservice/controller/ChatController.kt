package com.elice.aiservice.controller

import com.elice.aiservice.ai.service.ChatService
import com.elice.aiservice.controller.dto.DetermineSentenceRequestDto
import com.elice.aiservice.controller.dto.DetermineSentenceResponseDto
import com.elice.aiservice.controller.dto.GetRandomKeywordRequestDto
import com.elice.aiservice.controller.dto.GetRandomKeywordResponseDto
import com.elice.common.response.BaseResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(
    private val chatService: ChatService
) {
    @PostMapping("/determine/sentence")
    fun determineSentence(@RequestBody @Valid request: DetermineSentenceRequestDto): BaseResponse<DetermineSentenceResponseDto> {
        val response = chatService.determineSentence(request.topic, request.message)
        return BaseResponse(response)
    }

    @PostMapping("/random/keyword")
    fun getRandomKeyword(@RequestBody @Valid request: GetRandomKeywordRequestDto): BaseResponse<GetRandomKeywordResponseDto> {
        val response = chatService.getRandomKeyword(request.topic)
        return BaseResponse(GetRandomKeywordResponseDto(response))
    }
}