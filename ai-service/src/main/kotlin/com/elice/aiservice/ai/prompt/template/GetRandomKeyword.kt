package com.elice.aiservice.ai.prompt.template

class GetRandomKeyword {
    companion object {
        fun getSystemMessage(): String {
            return "Use the following step-by-step instructions." +
                    "STEP 1. When given a topic, Search Wikipedia for the topic and extract one word from it." +
                    "STEP 2. Your response must be exactly one word. Do not include any additional text, explanations, or formatting."
        }

        fun getAssistantMessage(topic: String): String {
            return "The topic is $topic"
        }
    }
}