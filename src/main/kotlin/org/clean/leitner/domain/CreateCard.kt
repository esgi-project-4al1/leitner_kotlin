package org.clean.leitner.domain

import org.clean.leitner.adapteur.`in`.CardCreateApi
import org.clean.leitner.adapteur.out.CardCreateSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.CardUserData
import org.clean.leitner.domain.model.Category
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreateCard(
    private val cardpersistence: CardCreateSpi,
): CardCreateApi {

    override fun createCard(card: CardUserData): Card {
        return cardpersistence.save(
            card.toCard()
        )
    }


    fun CardUserData.toCard(): Card{
        return Card(
            CardId(UUID.randomUUID().toString()),
            Category.FIRST,
            this.question,
            this.answer,
            this.tag
        )
    }
}