package org.example.todostep1.domain.card.model

import jakarta.persistence.*
import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.comment.model.Comment
import org.springframework.data.annotation.CreatedDate
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

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreatedDate // Entity 의 생성일자를 나타내는데 사용 저장될 때 현재 날짜(시간)으로 자동으로 설정되게 된다.
    @Column(name = "created_date", updatable = false)
    var createdDate: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")).toString()

    fun isCompleted() {
        status = CardStatus.TRUE
    }

    fun isNotCompleted() {
        status = CardStatus.FALSE
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
        createdDate = createdDate,
        name = name
    )

}

