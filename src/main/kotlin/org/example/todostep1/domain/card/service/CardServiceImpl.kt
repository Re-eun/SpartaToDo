package org.example.todostep1.domain.card.service

import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.card.dto.CreateCardRequest
import org.example.todostep1.domain.card.dto.UpdateCardRequest
import org.example.todostep1.domain.card.model.Card
import org.example.todostep1.domain.card.model.CardStatus
import org.example.todostep1.domain.card.model.toResponse
import org.example.todostep1.domain.card.repository.CardRepository
import org.example.todostep1.domain.comment.dto.AddCommentRequest
import org.example.todostep1.domain.comment.dto.CommentResponse
import org.example.todostep1.domain.comment.dto.UpdateCommentRequest
import org.example.todostep1.domain.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository
): CardService {
    override fun getAllCards(): List<CardResponse> {
        return cardRepository.findAll().map { it.toResponse() }.sortedByDescending{it.createdDate}
    }

    override fun getCard(cardId: Long): CardResponse {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card", cardId)
        return card.toResponse()
    }

    @Transactional
    override fun createCard(request: CreateCardRequest): CardResponse {
        return cardRepository.save(
            Card(
                title = request.title,
                content = request.content,
                name = request.name
            )
        ).toResponse()
    }

    @Transactional
    override fun updateCard(cardId: Long, request: UpdateCardRequest): CardResponse {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card", cardId)
        when(request.status) {
            CardStatus.TRUE.name -> card.isCompleted()
            CardStatus.FALSE.name -> card.isNotCompleted()
        }
        card.title = request.title
        card.content = request.content
        card.name = request.name
        return cardRepository.save(card).toResponse()
        }


    @Transactional
    override fun deleteCard(cardId: Long) {
        // id 에 해당하는 comment도 삭제 -> 영속성
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card", cardId)

        cardRepository.delete(card)

    }

    // 댓글
    override fun addComment(cardId: Long, request: AddCommentRequest): CommentResponse {
        // DB에서 ID 에 해당하는 카드 가져오고 request를 DB에 저장, commentresponse로 변환 후 반환
        // 비밀번호는 반환하지 않는다.
        // 해당하는 카드가 없다면 throw ModelNotFoundExcption
        TODO()
    }

    @Transactional
    override fun updateComment(cardId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        // 이름과 비밀번호가 저장된 값과 일치하지 않는다면 throw
        //DB에서 해당하는 id 의 카드 가져와서 request로 업데이트 후 저장, commentResponse로 변환 후 반환
        // 해당하는 댓글이 없다면 throw ModelNotFoundExcption
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteComment(cardId: Long, commentId: Long) {
        // 이름과 비밀번호가 저장된 값과 일치하지 않는다면 throw
        // 해당하는 댓글이 없다면 throw ModelNotFoundExcption
        //DB 에서 id 에 해당하는 카드의 댓글을 가져와서 삭제
        TODO("Not yet implemented")
    }
}