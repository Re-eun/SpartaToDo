package org.example.todostep1.domain.card.dto


data class CardResponse(
    val id: Long,
    val status: String,
    val title: String,
    val content: String?,
    val createdDate: String,
    val name: String
)
