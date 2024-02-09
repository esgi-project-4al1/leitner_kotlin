package org.clean.leitner.infrastructure.repository

import org.clean.leitner.infrastructure.entity.CardEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface CardRepository: MongoRepository<CardEntity, UUID> {

    fun findByTag(tag: String): List<CardEntity>
}