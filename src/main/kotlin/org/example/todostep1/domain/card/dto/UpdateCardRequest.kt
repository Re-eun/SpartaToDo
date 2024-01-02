package org.example.todostep1.domain.card.dto

data class UpdateCardRequest(
    val status: String,
    val title: String,
    val content: String,
    val name: String
)
