package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.`in`.CardAnswerApi
import org.clean.leitner.domain.adapteur.out.CardAnswerSpi
import org.clean.leitner.domain.model.Category
import org.springframework.stereotype.Service
import java.util.*

@Service
class AnswerCard(
    private val cardAnswerSpi: CardAnswerSpi
) : CardAnswerApi {

    override fun answerCardAction(cardId: UUID, goodResponse: Boolean): Boolean {
        val card = cardAnswerSpi.findCard(cardId = cardId) ?: return false
        val updateCard = card.copy(category = card.category.updateCategory(goodResponse))
        cardAnswerSpi.save(updateCard)
        return true
    }


    private fun Category.updateCategory(good: Boolean): Category {
        if (!good) {
            return Category.FIRST
        }
        return when (this) {
            Category.FIRST -> Category.SECOND
            Category.SECOND -> Category.THIRD
            Category.THIRD -> Category.FOURTH
            Category.FOURTH -> Category.FIFTH
            Category.FIFTH -> Category.SIXTH
            Category.SIXTH -> Category.SEVENTH
            Category.SEVENTH -> Category.DONE
            Category.DONE -> this
        }

    }


}