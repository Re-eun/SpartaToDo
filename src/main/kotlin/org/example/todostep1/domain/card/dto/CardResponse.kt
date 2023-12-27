package org.example.todostep1.domain.card.dto

import java.util.Date

data class CardResponse(
    val id: Long,
    val title: String,
    val content: String?,
    val createdDate: Date,
    val name: String
)
