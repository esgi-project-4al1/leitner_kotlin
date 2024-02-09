package org.clean.leitner.domain.model

import java.util.UUID

data class Card(
    val id : CardId ,
    val category : Category,
    val question : String,
    val answer : String,
    val tag :   String
)
