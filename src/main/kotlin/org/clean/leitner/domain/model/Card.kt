package org.clean.leitner.domain.model

import java.time.LocalDate

data class Card(
    val id : CardId ,
    val category : Category,
    val question : String,
    val answer : String,
    val tag :   String,
    val dateNextResponse: LocalDate? = LocalDate.now()
)
