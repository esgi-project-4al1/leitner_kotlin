package org.clean.leitner.domain

import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.CardUserData
import org.clean.leitner.domain.model.Category
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreateCard {

    fun create(cardUserData: CardUserData): Card {
        return Card(
            CardId(UUID.randomUUID().toString()),
            Category.FIRST,
            cardUserData.question,
            cardUserData.answer,
            cardUserData.tag
        )
    }
}