package org.example.todostep1.domain.card.model

import jakarta.persistence.*
import org.example.todostep1.domain.basetime.BaseTime
import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.card.dto.UpdateCardRequest
import org.example.todostep1.domain.card.repository.CardRepository
import org.example.todostep1.domain.comment.model.Comment
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.AbstractAuditable_.createdDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity
@Table(name = "card")
class Card(

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: CardStatus = CardStatus.FALSE,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    var content: String? = null,

    @Column(name = "name")
    var name: String,

    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val comments: MutableList<Comment> = mutableListOf()

): BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    fun isCompletedOrNot(request: UpdateCardRequest) {
        when(request.status) {
            CardStatus.TRUE.name ->  status = CardStatus.TRUE
            CardStatus.FALSE.name -> status = CardStatus.FALSE
        }
    }

    fun addComment(comment: Comment) {
        comments.add(comment)
    }

    fun removeComment(comment: Comment) {
        comments.remove(comment)
    }
}

fun Card.toResponse(): CardResponse {
    return CardResponse(
        id = id!!,
        status = status.name,
        title = title,
        content = content,
        createdAt = createdAt,
        name = name
    )

}

