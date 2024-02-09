package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.`in`.CardSearchApi
import org.clean.leitner.domain.model.Card
import org.springframework.stereotype.Service

@Service
class SearchCard(
    private val cardSearchApi : CardSearchApi
): CardSearchApi{
    override fun searchByTag(tag: String?): List<Card> {
       return emptyList()
    }

}