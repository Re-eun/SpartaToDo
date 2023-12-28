package org.example.todostep1.domain.comment.dto

data class UpdateCommentRequest(
    override var name: String,
    override var password: String,
    val content: String
): CheckRequest
