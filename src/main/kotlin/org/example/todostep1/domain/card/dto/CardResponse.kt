package org.example.todostep1.domain.card.dto


import org.example.todostep1.domain.card.model.CardStatus



data class CardResponse(
    val id: Long,
    val status: CardStatus,
    val title: String,
    val content: String?,
    val createdAt: String,
    val name: String
)
