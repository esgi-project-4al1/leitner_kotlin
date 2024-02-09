package org.clean.leitner.domain

import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.CardUserData
import org.clean.leitner.domain.model.Category
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import java.util.UUID

class CreateCardTest(){

    private val createCard = CreateCard()

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
        //WHEN
        whenever(createCard.create(cardUserData)).thenReturn(cardExpected)
        val cardResult = createCard.create(cardUserData)
        assertNotNull(cardResult)
        assertEquals(cardResult, cardExpected)
    }

}