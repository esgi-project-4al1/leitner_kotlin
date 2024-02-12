package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.out.CardAnswerSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.Category
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class AnswerCardTest {

    private val answerSpi = mock<CardAnswerSpi> { }
    private val answerCard = AnswerCard(answerSpi)


    @Test
    fun answerCardAction_GoodWithNotFoundCard() {
        val id = UUID.randomUUID()
        val responseGood = true
        val expectedResult = false
        whenever(answerSpi.findCard(eq(id))).thenReturn(null)
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }

    @Test
    fun answerCardAction_FalseWithNotFoundCard() {
        val id = UUID.randomUUID()
        val responseGood = false
        val expectedResult = false
        whenever(answerSpi.findCard(eq(id))).thenReturn(null)
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }

    @Test
    fun answerCardAction_GoodResponseFirstCategory() {
        val id = UUID.randomUUID()
        val card = createCard(id)
        val updateCard = card.copy(category = Category.SECOND)
        val responseGood = true
        val expectedResult = true
        whenever(answerSpi.findCard(eq(id))).thenReturn(card)
        whenever(answerSpi.save(eq(updateCard))).thenReturn(updateCard)
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }

    @Test
    fun answerCardAction_GoodResponseLastCategory() {
        val id = UUID.randomUUID()
        val card = createCard(id, Category.DONE)
        val responseGood = false
        val expectedResult = true
        whenever(answerSpi.findCard(eq(id))).thenReturn(card)
        whenever(answerSpi.save(eq(card))).thenReturn(card)
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }


    @Test
    fun answerCardAction_FalseResponseFirstCategory() {
        val id = UUID.randomUUID()
        val card = createCard(id)
        val responseGood = false
        val expectedResult = true
        whenever(answerSpi.findCard(eq(id))).thenReturn(card)
        whenever(answerSpi.save(eq(card))).thenReturn(card)
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)

    }

    @Test
    fun answerCardAction_FalseResponseLastCategory() {
        val id = UUID.randomUUID()
        val card = createCard(id, Category.DONE)
        val cardUpdated = card.copy(category = Category.FIRST)
        val responseGood = false
        val expectedResult = true
        whenever(answerSpi.findCard(eq(id))).thenReturn(card)
        whenever(answerSpi.save(eq(card))).thenReturn(cardUpdated)
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)

    }

    @Test
    fun answerCardAction_FalseResponseSecondCategory() {
        val id = UUID.randomUUID()
        val card = createCard(id, Category.SECOND)
        val cardUpdated = card.copy(category = Category.FIRST)
        val responseGood = false
        val expectedResult = true
        whenever(answerSpi.findCard(eq(id))).thenReturn(card)
        whenever(answerSpi.save(eq(card))).thenReturn(cardUpdated)
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)

    }

    private fun createCard(id: UUID, category: Category = Category.FIRST) = Card(
        id = CardId(
            id = id.toString()
        ),
        category = category,
        question = "question",
        answer = "answer",
        tag = "hello"
    )


}