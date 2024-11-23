package com.elice.aiservice.converter

import com.elice.aiservice.controller.dto.DetermineSentenceResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DetermineSentenceConverter(
    private val objectMapper: ObjectMapper
) : Converter<String, DetermineSentenceResponseDto> {

    override fun convert(source: String): DetermineSentenceResponseDto {
        return objectMapper.readValue(source, DetermineSentenceResponseDto::class.java)
    }
}