package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.`in`.CardSearchApi
import org.clean.leitner.domain.adapteur.out.CardSearchSpi
import org.clean.leitner.domain.model.Card
import org.springframework.stereotype.Service

@Service
class SearchCard(
    private val cardSearchSpi : CardSearchSpi
): CardSearchApi{
    override fun searchByTag(tags: List<String>): List<Card> {
       return  cardSearchSpi.findByTag(tags)
    }

}