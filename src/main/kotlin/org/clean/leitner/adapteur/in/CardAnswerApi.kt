package org.clean.leitner.adapteur.`in`

import java.util.*

interface CardAnswerApi {

    fun  answerCardAction(cardId: UUID, goodResponse: Boolean): Boolean
}