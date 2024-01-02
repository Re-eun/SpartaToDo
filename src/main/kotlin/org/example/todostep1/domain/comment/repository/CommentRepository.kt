package org.example.todostep1.domain.comment.repository

import org.example.todostep1.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {

    fun findByCardId(cardId: Long): List<Comment>

}