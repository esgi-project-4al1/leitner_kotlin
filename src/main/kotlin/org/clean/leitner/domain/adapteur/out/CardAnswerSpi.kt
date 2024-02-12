package org.clean.leitner.domain.adapteur.out

import org.clean.leitner.domain.model.Card
import java.util.UUID

interface CardAnswerSpi {

    fun findCard(cardId: UUID): Card?

    fun save(card: Card): Card
}