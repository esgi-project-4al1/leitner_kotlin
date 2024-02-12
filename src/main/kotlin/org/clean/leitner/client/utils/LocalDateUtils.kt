package org.clean.leitner.client.utils

import java.lang.Exception
import java.time.LocalDate

fun String.toLocalDate(): LocalDate?{
    return try {
        LocalDate.parse(this)
    }catch (e: Exception){
        null
    }
}