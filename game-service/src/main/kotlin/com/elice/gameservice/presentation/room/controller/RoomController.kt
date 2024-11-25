package com.elice.gameservice.presentation.room.controller

import com.elice.common.response.BaseResponse
import com.elice.common.response.BaseResponseStatus
import com.elice.common.response.PageResponse
import com.elice.gameservice.application.room.service.RoomService
import com.elice.gameservice.domain.room.store.RoomStore
import com.elice.gameservice.presentation.room.dto.CreateRoomRequestDto
import com.elice.gameservice.presentation.room.dto.GetMemberInRoomResponseDto
import com.elice.gameservice.presentation.room.dto.GetRoomRequestDto
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
class RoomController(
    private val roomService: RoomService,
    private val roomStore: RoomStore
) {
    @PostMapping("/room")
    fun createRoom(
        @RequestBody @Valid request: CreateRoomRequestDto,
        @RequestAttribute memberId: Long
    ): BaseResponse<GetRoomRequestDto> {
        val room = roomService.createRoom(request.subject, request.memberLimit, request.explanationSecond, memberId)
        return BaseResponse(
            GetRoomRequestDto(
                roomId = room.id!!,
                subject = room.subject,
                status = room.roomProgressState,
                memberCount = room.memberCount,
                explanationSecond = room.explanationSecond
            )
        )
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

    @GetMapping("/room")
    fun findRoom(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): BaseResponse<PageResponse<GetRoomRequestDto>> {
        val pageDto = roomService.findAllRoom(page, size)
        val pageResponse = PageResponse(
            content = pageDto.content.stream()
                .map { room ->
                    GetRoomRequestDto(
                        room.id!!,
                        room.subject,
                        room.roomProgressState,
                        room.memberCount,
                        room.explanationSecond
                    )
                }
                .toList(),
            totalElements = pageDto.totalElements,
            totalPages = pageDto.totalPages
        )
        return BaseResponse(pageResponse)
    }

    @GetMapping("/room/{roomId}/member")
    fun findMemberInRoom(
        @PathVariable roomId: Long
    ): BaseResponse<List<GetMemberInRoomResponseDto>> {
        val memberResponse = roomService.findMemberInRoom(roomId)
            .map {
                GetMemberInRoomResponseDto(
                    memberId = it.id!!,
                    name = it.name
                )
            }
        return BaseResponse(memberResponse)
    }

    @GetMapping("/topic")
    fun getTopicList(): BaseResponse<List<String>> {
        val topicList = roomStore.getTopicList()
            .map { it.topic }.toList()
        return BaseResponse(topicList)
    }
}