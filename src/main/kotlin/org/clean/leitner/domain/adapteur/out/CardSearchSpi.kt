package org.clean.leitner.domain.adapteur.out

import org.clean.leitner.domain.model.Card

interface CardSearchSpi {


    fun findByTag(tag : String?): List<Card>
}