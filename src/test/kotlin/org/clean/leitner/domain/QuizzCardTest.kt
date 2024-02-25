package org.clean.leitner.domain

import org.clean.leitner.adapteur.out.CardQuizzSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.Category
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.time.LocalDate
import java.util.*

class QuizzCardTest {

    private val cardQuizzSpi = mock<CardQuizzSpi> { }
    private val quizzCard = QuizzCard(
        cardQuizzSpi
    )

    @Test
    fun findCardForQuizzDay_Null() {
        val quizzDay = LocalDate.now().minusDays(1)
        whenever(cardQuizzSpi.findByBeforeNextDayResponseOrNow(date = quizzDay)).thenReturn(emptyList())
        val result = quizzCard.findCardForQuizzDay(quizzDay)
        assertEquals(emptyList<Card>(), result)
    }

    @Test
    fun findCardForQuizzDay_WithNotNull() {
        val quizzDay = LocalDate.now()
        val listCard = listOf(
            createCard().copy(dateNextResponse = LocalDate.now().minusDays(1)),
            createCard().copy(dateNextResponse = LocalDate.now().minusDays(4)),
            createCard()
        )
        whenever(cardQuizzSpi.findByBeforeNextDayResponseOrNow(date = quizzDay)).thenReturn(listCard)
        val result = quizzCard.findCardForQuizzDay(quizzDay)
        assertEquals(listCard, result)
    }


    private fun createCard(): Card {
        return Card(
            id = CardId(id = UUID.randomUUID().toString()),
            category = Category.FIRST,
            answer = "answer",
            tag = "tag",
            question = "question",
            dateNextResponse = LocalDate.now()
        )
    }
}