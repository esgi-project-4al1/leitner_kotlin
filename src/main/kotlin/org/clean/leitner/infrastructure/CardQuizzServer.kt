package org.clean.leitner.infrastructure

import org.clean.leitner.adapteur.out.CardQuizzSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.infrastructure.mapper.CardMapper
import org.clean.leitner.infrastructure.repository.CardRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CardQuizzServer(
    private val cardMapper: CardMapper,
    private val repository: CardRepository,
) : CardQuizzSpi {
    override fun findByBeforeNextDayResponseOrNow(date: LocalDate): List<Card> {
        val findCardEntity = repository.findByDateNextResponse(date) + repository.findByDateNextResponseIsBefore(date)
        return findCardEntity.stream().map { cardMapper.mappCardEntityToDomain(it) }.toList()
    }
}