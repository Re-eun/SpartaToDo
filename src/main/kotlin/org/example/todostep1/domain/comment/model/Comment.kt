package org.example.todostep1.domain.comment.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.example.todostep1.domain.card.model.Card
import org.springframework.data.annotation.CreatedDate
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

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreatedDate // Entity 의 생성일자를 나타내는데 사용 저장될 때 현재 날짜(시간)으로 자동으로 설정되게 된다.
    @Column(name = "created_date", updatable = false)
    var createdDate: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")).toString()

}
