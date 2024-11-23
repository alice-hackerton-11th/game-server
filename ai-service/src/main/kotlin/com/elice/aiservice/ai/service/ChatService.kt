package com.elice.aiservice.ai.service

import com.elice.aiservice.ai.prompt.template.DetermineSentence
import com.elice.aiservice.ai.prompt.template.GetRandomKeyword
import com.elice.aiservice.controller.dto.DetermineSentenceResponseDto
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.messages.SystemMessage
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

@Service
class ChatService(
    private val chatClient: ChatClient,
    private val determineSentenceConverter: Converter<String, DetermineSentenceResponseDto>
) {
    fun determineSentence(topic: String, message: String): DetermineSentenceResponseDto {
        val messages =
            listOf(
                SystemMessage(DetermineSentence.getSystemMessage()),
                AssistantMessage(DetermineSentence.getAssistantMessage(topic, message))
            )
        val content = chatClient
            .prompt()
            .messages(messages)
            .call()
            .content()
        return determineSentenceConverter.convert(content)!!
    }

    fun getRandomKeyword(topic: String): String {
        val messages =
            listOf(
                SystemMessage(GetRandomKeyword.getSystemMessage()),
                AssistantMessage(GetRandomKeyword.getAssistantMessage(topic))
            )
        val content = chatClient
            .prompt()
            .messages(messages)
            .call()
            .content()
        return content
    }
}