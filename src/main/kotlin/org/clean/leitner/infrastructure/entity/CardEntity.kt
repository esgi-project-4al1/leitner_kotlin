package org.clean.leitner.infrastructure.entity

import org.clean.leitner.domain.model.Category
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document("card")
data class CardEntity(
    val id : UUID,
    val category : Category,
    val question : String,
    val answer : String,
    val tag :   String
)
