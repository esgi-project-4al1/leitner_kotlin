package org.clean.leitner.infrastructure.repository

import org.clean.leitner.infrastructure.entity.CardEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface CardRepository : MongoRepository<CardEntity, String> {

    fun findByTag(tag: String): List<CardEntity>

    fun findByDateNextResponseIsBefore(localDate: LocalDate): List<CardEntity>

    fun findByDateNextResponse(localDate: LocalDate): List<CardEntity>
}