package org.clean.leitner.client

import org.clean.leitner.domain.adapteur.`in`.CardCreateApi
import org.clean.leitner.domain.adapteur.`in`.CardSearchApi
import org.clean.leitner.domain.model.Card
import org.clean.leitner.domain.model.CardUserData
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardController(
    private val cardCreateApi: CardCreateApi,
    private val cardSearchApi: CardSearchApi,
) {

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createCard(
        @RequestBody(required = true) cardUserData: CardUserData
    ): Card{
        return cardCreateApi.createCard(cardUserData)
    }


    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun searchCard(
        @RequestParam(required = false, defaultValue = "") tag: List<String>
    ): List<Card> {
        return cardSearchApi.searchByTag(tag)
    }

}