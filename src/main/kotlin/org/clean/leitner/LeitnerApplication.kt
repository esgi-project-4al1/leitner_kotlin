package org.clean.leitner

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories
@SpringBootApplication
class LeitnerApplication

fun main(args: Array<String>) {
    runApplication<LeitnerApplication>(*args)
}
