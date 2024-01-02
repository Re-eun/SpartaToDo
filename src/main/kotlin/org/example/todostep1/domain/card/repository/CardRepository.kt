package org.example.todostep1.domain.card.repository

import org.example.todostep1.domain.card.model.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<Card, Long> {

}