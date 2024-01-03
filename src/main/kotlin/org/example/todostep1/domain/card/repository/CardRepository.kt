package org.example.todostep1.domain.card.repository

import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.card.model.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<Card, Long> {
    fun findAllByNameOrderByCreatedAt(name:String): List<CardResponse>

    fun findAllByNameOrderByCreatedAtDesc(name: String): List<CardResponse>

}