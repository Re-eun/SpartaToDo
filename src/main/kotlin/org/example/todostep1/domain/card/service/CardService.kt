package org.example.todostep1.domain.card.service

import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.card.dto.CreateCardRequest
import org.example.todostep1.domain.card.dto.UpdateCardRequest

interface CardService {
    fun getAllCards(): List<CardResponse>
    fun getCard(cardId: Long): CardResponse
    fun createCard(request: CreateCardRequest): CardResponse
    fun updateCard(cardId: Long, request: UpdateCardRequest): CardResponse
    fun deleteCard(cardId: Long)
}