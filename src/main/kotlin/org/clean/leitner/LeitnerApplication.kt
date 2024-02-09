package org.clean.leitner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LeitnerApplication

fun main(args: Array<String>) {
    runApplication<LeitnerApplication>(*args)
}
