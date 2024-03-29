package org.clean.leitner.adapteur.out

import org.clean.leitner.domain.model.Card
import java.time.LocalDate

interface CardQuizzSpi {

    fun findByBeforeNextDayResponseOrNow(date: LocalDate): List<Card>
}