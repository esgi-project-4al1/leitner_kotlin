package org.clean.leitner.client.utils

import org.clean.leitner.client.dto.CardDto
import org.clean.leitner.domain.model.Card

fun Card.toClient(): CardDto {
    return CardDto(
        this.id.id,
        this.category,
        this.question,
        this.answer,
        this.tag
    )
}