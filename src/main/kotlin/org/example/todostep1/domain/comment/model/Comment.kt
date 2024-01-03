package org.example.todostep1.domain.comment.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.example.todostep1.domain.basetime.BaseTime
import org.example.todostep1.domain.card.model.Card
import org.example.todostep1.domain.comment.dto.CheckRequest
import org.example.todostep1.domain.comment.dto.CommentResponse
import org.example.todostep1.domain.comment.repository.CommentRepository
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.AbstractAuditable_.createdDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity
@Table(name = "comment")
class Comment(

    @Column(name = "name")
    var name: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "password")
    var password: String,

    @ManyToOne
    @JoinColumn(name = "card_id")
    val card: Card

): BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun isNameAndPasswordInCorrect(request: CheckRequest): Boolean {
        return request.name != this.name || request.password != this.password
    }

}

fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        id = id!!,
        name = name,
        content = content,
        createdAt = createdAt
    )
}
