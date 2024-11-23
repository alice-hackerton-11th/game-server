package com.elice.aiservice.ai.prompt.template

class GetRandomKeyword {
    companion object {
        fun getSystemMessage(): String {
            return "Use the following step-by-step instructions." +
                    "STEP 1. When given a topic, tell me the relevant keywords" +
                    "STEP 2. When giving an answer, please say it in one word"
        }

        fun getAssistantMessage(topic: String): String {
            return "The topic is $topic"
        }
    }
}