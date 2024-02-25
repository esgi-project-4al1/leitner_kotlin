package org.clean.leitner.adapteur.`in`

import org.clean.leitner.domain.model.Card

interface CardSearchApi {

    fun searchByTag(tags: List<String>): List<Card>
}