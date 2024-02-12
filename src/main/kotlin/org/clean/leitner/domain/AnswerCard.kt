package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.`in`.CardAnswerApi
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AnswerCard: CardAnswerApi {
    override fun answerCardAction(cardId: UUID, goodResponse: Boolean): Boolean {
        TODO("Not yet implemented")
    }


}