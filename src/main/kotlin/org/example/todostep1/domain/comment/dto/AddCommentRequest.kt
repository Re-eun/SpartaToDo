package org.example.todostep1.domain.comment.dto

data class AddCommentRequest(
    val name: String,
    val content: String,
    val password: String
)
