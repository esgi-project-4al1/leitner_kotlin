package org.clean.leitner.infrastructure

import org.clean.leitner.adapteur.out.CardAnswerSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.infrastructure.mapper.CardMapper
import org.clean.leitner.infrastructure.repository.CardRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class CardAnswerServer(
    private val cardMapper: CardMapper,
    private val repository: CardRepository,
) : CardAnswerSpi {
    override fun findCard(cardId: UUID): Card? {
        val cardEntity = repository.findById(cardId.toString()).getOrNull() ?: return null
        return cardEntity.let { cardMapper.mappCardEntityToDomain(it) }
    }

    override fun save(card: Card): Card {
        val cardEntity = cardMapper.mappCardToServer(card)
        return repository.save(cardEntity).let { cardMapper.mappCardEntityToDomain(it) }
    }
}