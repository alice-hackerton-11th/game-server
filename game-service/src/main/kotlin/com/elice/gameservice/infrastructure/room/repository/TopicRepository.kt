package com.elice.gameservice.infrastructure.room.repository

import com.elice.gameservice.domain.room.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
    override fun findAll(): List<Topic>
}