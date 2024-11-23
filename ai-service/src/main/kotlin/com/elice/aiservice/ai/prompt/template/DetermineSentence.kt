package com.elice.aiservice.ai.prompt.template

class DetermineSentence {
    companion object {
        fun getSystemMessage(): String {
            return "Use the following step-by-step instructions." +
                    "STEP 1. When a topic and a message are given in sequence," +
                    "determine whether the message is true or false from the perspective of the topic " +
                    "and express the accuracy of the judgment as a decimal." +
                    "STEP 2. You are an assistant that provides responses in a strict JSON format." +
                    "Always respond with valid JSON, and nothing else." +
                    "The JSON format should match the following example: " +
                    "{\n" +
                    "  \"isTrue\": true,\n" +
                    "  \"confidence\": 0.567,\n" +
                    "}"
        }

        fun getAssistantMessage(topic: String, message: String): String {
            return "The topic is $topic and the sentence to be determined is $message"
        }
    }
}