package org.example.todostep1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class ToDoStep1Application

fun main(args: Array<String>) {
    runApplication<ToDoStep1Application>(*args)
}
