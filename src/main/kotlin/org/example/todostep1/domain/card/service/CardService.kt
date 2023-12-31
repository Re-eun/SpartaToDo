package org.example.todostep1.domain.card.service

import org.example.todostep1.domain.card.dto.*
import org.example.todostep1.domain.card.model.AscOrDesc
import org.example.todostep1.domain.comment.dto.AddCommentRequest
import org.example.todostep1.domain.comment.dto.CommentResponse
import org.example.todostep1.domain.comment.dto.DeleteCommentRequest
import org.example.todostep1.domain.comment.dto.UpdateCommentRequest

interface CardService {
    fun getAllCards(name:String, order:AscOrDesc): List<CardResponse>
    fun getCard(cardId: Long): CardWithCommentResponse
    fun createCard(request: CreateCardRequest): CardResponse
    fun updateCard(cardId: Long, request: UpdateCardRequest): CardResponse
    fun deleteCard(cardId: Long)

    fun addComment(cardId: Long, request: AddCommentRequest): CommentResponse
    fun updateComment(cardId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse
    fun deleteComment(cardId: Long, commentId: Long, request: DeleteCommentRequest)
}