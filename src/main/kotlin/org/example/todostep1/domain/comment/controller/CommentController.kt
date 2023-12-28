package org.example.todostep1.domain.comment.controller

import org.example.todostep1.domain.card.service.CardService
import org.example.todostep1.domain.comment.dto.AddCommentRequest
import org.example.todostep1.domain.comment.dto.CommentResponse
import org.example.todostep1.domain.comment.dto.DeleteCommentRequest
import org.example.todostep1.domain.comment.dto.UpdateCommentRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards/{cardId}/comments")
class CommentController(
    private val cardService: CardService
) {

    @PostMapping
    fun addComment(@PathVariable cardId: Long,
                   @RequestBody addCommentRequest: AddCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(cardService.addComment(cardId, addCommentRequest))
    }

    @PutMapping("/{commentId}")
    fun updateComment(@PathVariable cardId: Long,
                      @PathVariable commentId: Long,
                      @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.updateComment(cardId, commentId, updateCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable cardId: Long,
                      @PathVariable commentId: Long,
                      @RequestBody deleteCommentRequest: DeleteCommentRequest
    ): ResponseEntity<Unit> {
        return  ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(cardService.deleteComment(cardId, commentId, deleteCommentRequest))
    }
}