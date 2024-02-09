package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.out.CardSearchSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardId
import org.clean.leitner.domain.model.Category
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class SearchCardTest{

    private val searchCardRepository = mock<CardSearchSpi> {  }
    private val cardSearch = SearchCard(
        searchCardRepository,
    )
    @Test
    fun searchCardsByTag(){
        //GIVE
        val tag = "TeamWork"
        val cardList = listOf(
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            )
            ,Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            ),
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            ),
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "tag",
            )
        )

        whenever(searchCardRepository.findByTag(tag)).thenReturn(cardList)
        val cardResult = cardSearch.searchByTag(tag)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(3, cardResult.size)
            cardResult.stream().forEach{
                assertEquals(tag, it.tag)
            }
        })
    }

    @Test
    fun searchCardsWithoutTag(){
        //GIVE
        val tag = null
        val cardList = listOf(
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            )
            ,Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            ),
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            ),
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "tag",
            )
        )

        whenever(searchCardRepository.findByTag(tag)).thenReturn(cardList)
        val cardResult = cardSearch.searchByTag(tag)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(4, cardResult.size)
        })
    }


    @Test
    fun searchCardWithoutCards(){
        //GIVE
        val tag = null
        val cardList = emptyList<Card>()
        whenever(searchCardRepository.findByTag(tag)).thenReturn(cardList)
        val cardResult = cardSearch.searchByTag(tag)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(0, cardResult.size)
        })
    }

    @Test
    fun searchCardWithUnknownTag(){
        //GIVE
        val tag = "null"
        val cardList = listOf(
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            )
            ,Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            ),
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "TeamWork",
            ),
            Card(
                CardId(
                    UUID.randomUUID().toString()
                ),
                Category.FIRST,
                "question",
                "answer",
                "tag",
            )
        )
        whenever(searchCardRepository.findByTag(tag)).thenReturn(cardList)
        val cardResult = cardSearch.searchByTag(tag)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(0, cardResult.size)
        })
    }
}