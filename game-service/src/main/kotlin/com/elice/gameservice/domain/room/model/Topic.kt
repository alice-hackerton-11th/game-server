package com.elice.gameservice.domain.room.model

import com.elice.gameservice.domain.common.model.BaseModel
import jakarta.persistence.*

@Entity
class Topic(
    val topic: String
) : BaseModel() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    var id: Long? = null
}