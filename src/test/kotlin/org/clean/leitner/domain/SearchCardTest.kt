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
import kotlin.collections.List

class SearchCardTest{

    private val searchCardRepository = mock<CardSearchSpi> {  }
    private val cardSearch = SearchCard(
        searchCardRepository,
    )
    @Test
    fun searchCardsByTag(){
        //GIVE
        val tags = listOf("TeamWork")
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
                "tags",
            )
        )

        val cardReturn = cardList.stream().filter { tags.contains(it.tag) }.toList()
        whenever(searchCardRepository.findByTag(tags)).thenReturn(cardReturn)

        val cardResult = cardSearch.searchByTag(tags)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(3, cardResult.size)
            cardResult.forEach { card ->
                assertEquals(tags.first(), card.tag)
            }
        })

    }

    @Test
    fun searchCardsWithoutTag(){
        //GIVEN
        val tags: List<String> = emptyList()
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
                "tags",
            )
        )

        whenever(searchCardRepository.findByTag(tags)).thenReturn(cardList)
        val cardResult = cardSearch.searchByTag(tags)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(4, cardResult.size)
        })
    }

    @Test
    fun searchCardWithoutCards(){
        //GIVEN
        val tags: List<String> = emptyList()
        val cardList = emptyList<Card>()
        whenever(searchCardRepository.findByTag(tags)).thenReturn(cardList)
        val cardResult = cardSearch.searchByTag(tags)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(0, cardResult.size)
        })
    }

    @Test
    fun searchCardWithUnknownTag(){
        //GIVEN
        val tags: List<String> = listOf("null")
        val cardList = emptyList<Card>()
        whenever(searchCardRepository.findByTag(tags)).thenReturn(cardList)
        val cardResult = cardSearch.searchByTag(tags)
        assertAll({
            assertNotNull(cardResult)
            assertEquals(0, cardResult.size)
        })
    }


    fun List<String>.contentOneString(tags: List<String>): Boolean {
        return this.any { it in tags }
    }
}