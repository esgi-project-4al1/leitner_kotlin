package org.clean.leitner.client.utils

import java.lang.Exception
import java.util.*

fun tryCatch(id: String): UUID? {
    return try {
        UUID.fromString(id)
    }catch (e: Exception){
        null
    }
}