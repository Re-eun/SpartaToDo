package org.example.todostep1.domain.comment.dto

data class DeleteCommentRequest(
    override var name: String,
    override var password: String,
): CheckRequest
