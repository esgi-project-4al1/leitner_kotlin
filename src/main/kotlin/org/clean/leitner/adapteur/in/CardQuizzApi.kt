package org.clean.leitner.adapteur.`in`

import org.clean.leitner.domain.model.Card
import java.time.LocalDate

interface CardQuizzApi {

    fun findCardForQuizzDay(date: LocalDate): List<Card>
}