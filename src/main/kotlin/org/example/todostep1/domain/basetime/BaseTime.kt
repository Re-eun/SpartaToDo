package org.example.todostep1.domain.basetime

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@MappedSuperclass // Entity 클래스들이 해당 클래스를 상속받을 경우 필드를 Column으로 인식하도록 함
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTime {

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate //  Entity 가 생성되어 저장될 때 시간이 자동으로 저장됨
    var createdAt: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH-mm"))
}