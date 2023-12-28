package org.example.todostep1.domain.comment.repository

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository("Comment", Long) {
}