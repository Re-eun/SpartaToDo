package org.example.todostep1.domain.card.dto

import java.time.LocalDateTime


data class CardResponse(
    val id: Long,
    val status: String,
    val title: String,
    val content: String?,
    val createdAt: String,
    val name: String
)
