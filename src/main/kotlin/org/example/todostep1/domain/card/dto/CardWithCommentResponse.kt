package org.example.todostep1.domain.card.dto

import org.example.todostep1.domain.comment.dto.CommentResponse

data class CardWithCommentResponse(
    val card: CardResponse,
    val comments: List<CommentResponse>
)
