package org.example.todostep1.domain.card.controller

import org.example.todostep1.domain.card.dto.*
import org.example.todostep1.domain.card.model.AscOrDesc
import org.example.todostep1.domain.card.service.CardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards")
@RestController
class CardController(
    private val cardService: CardService
) {

    @GetMapping
    fun getAllCards(@RequestParam name:String, @RequestParam order:AscOrDesc): ResponseEntity<List<CardResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getAllCards(name, order))
    }

    @GetMapping("/{cardId}")
    fun getcard(@PathVariable cardId: Long): ResponseEntity<CardWithCommentResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCard(cardId))
    }

    @PostMapping
    fun createCard(@Validated @RequestBody createCardRequest: CreateCardRequest): ResponseEntity<CardResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.createCard(createCardRequest))
    }

    @PutMapping("/{cardId}")
    fun updateCard(@Validated @PathVariable cardId: Long, @RequestBody updateCardRequest: UpdateCardRequest): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.updateCard(cardId, updateCardRequest))
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(@PathVariable cardId: Long): ResponseEntity<String> {
        cardService.deleteCard(cardId)
        val deleteTodoSuccessMessage = "할일이 성공적으로 삭제되었습니다."

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(deleteTodoSuccessMessage)
    }

}

