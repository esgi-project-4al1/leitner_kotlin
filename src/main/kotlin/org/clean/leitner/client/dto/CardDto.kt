package org.clean.leitner.client.dto

import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.Category

data class CardDto(
    val id: String,
    val category: Category,
    val question: String,
    val answer: String,
    val tag: String
)
