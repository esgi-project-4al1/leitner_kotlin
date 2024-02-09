package org.clean.leitner.infrastructure

import org.clean.leitner.domain.adapteur.out.CardCreateSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.infrastructure.mapper.CardMapper
import org.clean.leitner.infrastructure.repository.CardRepository
import org.springframework.stereotype.Service

@Service
class CardCreateServer(
    private val cardMapper: CardMapper,
    private val cardRepository: CardRepository,
) : CardCreateSpi {
    override fun save(card: Card): Card {
        return cardRepository.save(
            cardMapper.mappCardToServer(card)
        ).let { cardMapper.mappCardEntityToDomain(it) }
    }


}