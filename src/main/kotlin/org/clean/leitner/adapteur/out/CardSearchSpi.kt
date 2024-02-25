package org.clean.leitner.adapteur.out

import org.clean.leitner.domain.model.Card

interface CardSearchSpi {

    fun findByTag(tags : List<String>): List<Card>
}