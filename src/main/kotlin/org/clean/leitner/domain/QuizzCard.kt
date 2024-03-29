package org.clean.leitner.domain

import org.clean.leitner.adapteur.`in`.CardQuizzApi
import org.clean.leitner.adapteur.out.CardQuizzSpi
import org.clean.leitner.domain.model.Card
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class QuizzCard(
    private val cardQuizzSpi: CardQuizzSpi
): CardQuizzApi {
    override fun findCardForQuizzDay(date: LocalDate): List<Card> {
        return cardQuizzSpi.findByBeforeNextDayResponseOrNow(date)
    }
}