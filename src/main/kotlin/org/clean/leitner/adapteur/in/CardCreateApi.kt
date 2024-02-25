package org.clean.leitner.adapteur.`in`

import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardUserData

interface CardCreateApi {

    fun createCard(card: CardUserData): Card
}