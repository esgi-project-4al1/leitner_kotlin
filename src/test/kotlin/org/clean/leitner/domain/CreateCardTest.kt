package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.out.CardCreateSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.CardUserData
import org.clean.leitner.domain.model.Category
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.UUID

class CreateCardTest{

    private val createCardRepository = mock<CardCreateSpi> {  }
    private val createCard = CreateCard(
        createCardRepository,
    )

    @Test
    fun createCard(){
        //GIVE
        val cardUserData = CardUserData("question", "answer", "tag")
        val cardExpected = Card(
            CardId(
                UUID.randomUUID().toString()
            ),
            Category.FIRST,
            "question",
            "answer",
            "tag",
        )

        whenever(createCardRepository.save(any())).thenReturn(cardExpected)
        val cardResult = createCard.createCard(cardUserData)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(cardExpected.tag, cardResult.tag)
            assertEquals(cardExpected.answer, cardResult.answer)
            assertEquals(cardExpected.question, cardResult.question)
        })
    }
}