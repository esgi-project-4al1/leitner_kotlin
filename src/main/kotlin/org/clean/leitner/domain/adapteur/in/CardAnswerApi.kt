package org.clean.leitner.domain.adapteur.`in`

import java.util.*

interface CardAnswerApi {

    fun  answerCardAction(cardId: UUID, goodResponse: Boolean): Boolean?
}