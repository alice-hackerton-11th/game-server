package com.elice.gameservice.presentation.room.controller

import com.elice.common.response.BaseResponse
import com.elice.common.response.BaseResponseStatus
import com.elice.gameservice.application.room.service.RoomService
import com.elice.gameservice.presentation.room.dto.CreateRoomRequestDto
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/room/{roomId}/enter")
    fun enterRoom(
        @PathVariable roomId: Long,
        @RequestAttribute memberId: Long
    ): BaseResponse<Any> {
        roomService.enterRoom(roomId, memberId)
        return BaseResponse(BaseResponseStatus.SUCCESS)
    }

    @DeleteMapping("/room/{roomId}/exit")
    fun exitRoom(
        @PathVariable roomId: Long,
        @RequestAttribute memberId: Long
    ): BaseResponse<Any> {
        roomService.exitRoom(roomId, memberId)
        return BaseResponse(BaseResponseStatus.SUCCESS)
    }

}