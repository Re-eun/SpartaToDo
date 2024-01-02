package org.example.todostep1.domain.comment.dto

import java.time.LocalDateTime


data class CommentResponse(
    val id: Long,
    val name: String,
    val content: String,
    val createdAt: String
)
