package org.example.todostep1.domain.card.controller

import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.card.dto.CreateCardRequest
import org.example.todostep1.domain.card.dto.UpdateCardRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards")
@RestController
class CardController {

    @GetMapping
    fun getAllCards(): ResponseEntity<CardResponse> {
        TODO()
    }

    @GetMapping("/{cardId}")
    fun getcard(@PathVariable cardId: Long): ResponseEntity<CardResponse> {
        TODO()
    }

    @PostMapping
    fun createCard(@RequestBody createCardRequest: CreateCardRequest): ResponseEntity<CardResponse> {
        TODO()
    }

    @PutMapping("/{cardId}")
    fun updateCard(@PathVariable cardId: Long, @RequestBody updateCardRequest: UpdateCardRequest): ResponseEntity<CardResponse> {
        TODO()
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(@PathVariable cardId: Long): ResponseEntity<Unit> {
        TODO()
    }

}