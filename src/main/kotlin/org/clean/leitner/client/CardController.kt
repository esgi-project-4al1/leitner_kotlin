package org.clean.leitner.client

import org.clean.leitner.client.dto.CardDto
import org.clean.leitner.client.utils.toClient
import org.clean.leitner.client.utils.toLocalDate
import org.clean.leitner.client.utils.tryCatch
import org.clean.leitner.domain.adapteur.`in`.CardAnswerApi
import org.clean.leitner.domain.adapteur.`in`.CardCreateApi
import org.clean.leitner.domain.adapteur.`in`.CardQuizzApi
import org.clean.leitner.domain.adapteur.`in`.CardSearchApi
import org.clean.leitner.domain.model.CardUserData
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cards")
class CardController(
    private val cardCreateApi: CardCreateApi,
    private val cardSearchApi: CardSearchApi,
    private val cardAnswerApi: CardAnswerApi,
    private val cardQuizzApi: CardQuizzApi,
) {

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createCard(
        @RequestBody(required = true) cardUserData: CardUserData
    ): CardDto {
        return cardCreateApi.createCard(cardUserData).toClient()
    }


    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun searchCard(
        @RequestParam(required = false, defaultValue = "") tag: List<String>
    ): List<CardDto> {
        return cardSearchApi.searchByTag(tag).stream().map { it.toClient() }.toList()
    }

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        path = ["/quizz"]
    )
    fun quizzCard(
        @RequestParam(required = true) date: String
    ): List<CardDto> {
        val localDate = date.toLocalDate() ?: return emptyList()
        return cardQuizzApi.findCardForQuizzDay(localDate).stream().map { it.toClient() }.toList()
    }

    @PatchMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        path = ["{cardId}/answer"]
    )
    fun answerCard(
        @PathVariable cardId: String,
        @RequestBody(required = true) isValid: Boolean
    ): HttpStatus {
        val cardUUID = tryCatch(cardId) ?: return HttpStatus.NOT_FOUND
        val result = cardAnswerApi.answerCardAction(cardUUID, isValid)
        if (result) return HttpStatus.NOT_FOUND
        return HttpStatus.NO_CONTENT
    }

}