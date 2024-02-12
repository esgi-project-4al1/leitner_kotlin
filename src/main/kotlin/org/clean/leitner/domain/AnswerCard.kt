package org.clean.leitner.domain

import org.clean.leitner.domain.adapteur.`in`.CardAnswerApi
import org.clean.leitner.domain.adapteur.out.CardAnswerSpi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.Category
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class AnswerCard(
    private val cardAnswerSpi: CardAnswerSpi
) : CardAnswerApi {

    private val mapCategoryToDay: Map<Category, Long> = mapOf(
        Category.FIRST to 1,
        Category.SECOND to 2,
        Category.THIRD to 4,
        Category.FOURTH to 8,
        Category.FIFTH to 16,
        Category.SIXTH to 32,
        Category.SEVENTH to 64,
    )


    override fun answerCardAction(cardId: UUID, goodResponse: Boolean): Boolean {
        val card = cardAnswerSpi.findCard(cardId = cardId) ?: return false
        val updateCard = card.copy(category = card.category.updateCategory(goodResponse)).updateNextResponse()
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

    private fun Card.updateNextResponse(): Card {
        return this.copy(
            dateNextResponse = this.dateNextResponse?.plusDayNextResponse(this.category)
        )
    }

    private fun LocalDate?.plusDayNextResponse(category: Category?): LocalDate? {
        if (category == Category.DONE || this == null) return null
        return this.plusDays(mapCategoryToDay[category]!!)
    }


}