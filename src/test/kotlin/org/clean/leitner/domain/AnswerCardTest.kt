package org.clean.leitner.domain

import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.Category
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class AnswerCardTest{

    private val answerCard = AnswerCard()



    @Test
    fun answerCardAction_GoodWithNotFoundCard(){
        val id = UUID.randomUUID()
        val card = createCard(id)
        val responseGood = true
        val expectedResult = null
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }

    @Test
    fun answerCardAction_FalseWithNotFoundCard(){
        val id = UUID.randomUUID()
        val card = createCard(id)
        val responseGood = false
        val expectedResult = null
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }

    @Test
    fun answerCardAction_GoodResponseFirstCategory(){
        val id = UUID.randomUUID()
        val card = createCard(id)
        val updateCard = null
        val responseGood = false
        val expectedResult = true
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }

    @Test
    fun answerCardAction_GoodResponseLastCategory(){
        val id = UUID.randomUUID()
        val card = createCard(id, Category.DONE)
        val updateCard = null
        val responseGood = false
        val expectedResult = true
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)
    }


    @Test
    fun answerCardAction_FalseResponseFirstCategory(){
        val id = UUID.randomUUID()
        val card = createCard(id)
        val updateCard = null
        val responseGood = false
        val expectedResult = true
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)

    }

    @Test
    fun answerCardAction_FalseResponseLastCategory(){
        val id = UUID.randomUUID()
        val card = createCard(id, Category.DONE)
        val updateCard = null
        val responseGood = false
        val expectedResult = true
        val result = answerCard.answerCardAction(id, responseGood)
        assertEquals(expectedResult, result)

    }

    @Test
    fun answerCardAction_FalseResponseSecondCategory(){
        val id = UUID.randomUUID()
        val card = createCard(id, Category.SECOND)
        val updateCard = null
        val responseGood = false
        val expectedResult = true
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