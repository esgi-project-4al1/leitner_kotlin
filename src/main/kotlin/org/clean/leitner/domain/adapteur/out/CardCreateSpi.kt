package org.clean.leitner.domain.adapteur.out

import org.clean.leitner.domain.model.Card

interface CardCreateSpi {

    fun save(card :Card): Card
}