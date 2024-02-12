package org.clean.leitner.infrastructure.mapper

import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.infrastructure.entity.CardEntity
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CardMapper {

    fun mappCardEntityToDomain(cardEntity: CardEntity): Card {
        return Card(
            CardId(
                id= cardEntity.id.toString()
            ),
            category = cardEntity.category,
            question = cardEntity.question,
            answer = cardEntity.answer,
            tag = cardEntity.tag,
        )
    }

    fun mappCardToServer(card: Card): CardEntity{
        return CardEntity(
           id= UUID.fromString(card.id.id),
            category = card.category,
            question = card.question,
            answer = card.answer,
            tag = card.tag,
            dateNextResponse = card.dateNextResponse
        )
    }
}