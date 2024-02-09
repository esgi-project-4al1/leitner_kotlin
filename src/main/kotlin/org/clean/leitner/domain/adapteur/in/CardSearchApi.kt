package org.clean.leitner.domain.adapteur.`in`

import org.clean.leitner.domain.model.Card

interface CardSearchApi {

    fun searchByTag(tag: List<String?>): List<Card>
}