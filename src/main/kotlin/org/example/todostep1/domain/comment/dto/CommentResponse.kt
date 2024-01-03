package org.example.todostep1.domain.comment.dto



data class CommentResponse(
    val id: Long,
    val name: String,
    val content: String,
    val createdAt: String
)
