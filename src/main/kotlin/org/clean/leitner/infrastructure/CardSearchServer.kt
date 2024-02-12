package org.clean.leitner.infrastructure

import org.clean.leitner.domain.adapteur.out.CardSearchSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.infrastructure.entity.CardEntity
import org.clean.leitner.infrastructure.mapper.CardMapper
import org.clean.leitner.infrastructure.repository.CardRepository
import org.springframework.stereotype.Service

@Service
class CardSearchServer(
    private val cardRepository: CardRepository,
    private val cardMapper: CardMapper,
) : CardSearchSpi {

    override fun findByTag(tags: List<String>): List<Card> {
        return tags.flatMap { tag -> cardRepository.findByTag(tag) }
                .map { card -> cardMapper.mappCardEntityToDomain(card) }.toList()
    }

}