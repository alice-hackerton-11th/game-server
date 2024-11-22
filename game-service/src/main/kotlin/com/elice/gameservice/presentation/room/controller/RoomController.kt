package com.elice.gameservice.presentation.room.controller

import com.elice.common.response.BaseResponse
import com.elice.common.response.BaseResponseStatus
import com.elice.gameservice.application.room.service.RoomService
import com.elice.gameservice.presentation.room.dto.CreateRoomRequestDto
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController(
    private val roomService: RoomService
) {
    @PostMapping("/room")
    fun createRoom(
        @RequestBody @Valid request: CreateRoomRequestDto,
        @RequestAttribute memberId: Long
    ): BaseResponse<Any> {
        roomService.createRoom(request.subject, request.memberLimit, request.explanationSecond, memberId)
        return BaseResponse(BaseResponseStatus.SUCCESS)
    }
}