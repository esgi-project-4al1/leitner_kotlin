package org.clean.leitner.infrastructure.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
data class UserEntity (
    @Id
    val id : String,
    val name : String,
    val apiKey: String
)