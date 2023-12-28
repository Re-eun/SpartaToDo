package org.example.todostep1.domain.comment.dto

data class UpdateCommentRequest(
    val name: String,
    val password: String,
    val content: String
)
