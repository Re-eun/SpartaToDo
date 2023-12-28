package org.example.todostep1.domain.card.service

import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.card.dto.CardWithCommentResponse
import org.example.todostep1.domain.card.dto.CreateCardRequest
import org.example.todostep1.domain.card.dto.UpdateCardRequest
import org.example.todostep1.domain.card.model.Card
import org.example.todostep1.domain.card.model.CardStatus
import org.example.todostep1.domain.card.model.toResponse
import org.example.todostep1.domain.card.repository.CardRepository
import org.example.todostep1.domain.comment.dto.AddCommentRequest
import org.example.todostep1.domain.comment.dto.CommentResponse
import org.example.todostep1.domain.comment.dto.UpdateCommentRequest
import org.example.todostep1.domain.comment.model.Comment
import org.example.todostep1.domain.comment.model.toResponse
import org.example.todostep1.domain.comment.repository.CommentRepository
import org.example.todostep1.domain.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository,
    private val commentRepository: CommentRepository
): CardService {

    override fun getAllCards(): List<CardResponse> {
        return cardRepository.findAll().map { it.toResponse() }.sortedByDescending{it.createdDate}
    }

    // 단건 카드 조회 시 댓글도 같이 조회되도록
    override fun getCard(cardId: Long): CardWithCommentResponse {
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card", cardId)
        val comments = commentRepository.findByCardId(cardId).toList().map { it.toResponse() }
        return CardWithCommentResponse(card.toResponse(), comments)
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
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("card", cardId)

        val comment = Comment(
            name = request.name,
            content = request.content,
            password = request.password,
            card = card // card와의 연결
        )

        card.addComment(comment)
        cardRepository.save(card) // card에 저장 -> 영속성 전파
        return comment.toResponse()
    }

    @Transactional
    override fun updateComment(cardId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        // 이름과 비밀번호가 저장된 값과 일치하지 않는다면 throw UnAuthorizedAccess
        //DB에서 해당하는 id 의 카드 가져와서 request로 업데이트 후 저장, commentResponse로 변환 후 반환
        // 해당하는 댓글이 없다면 throw ModelNotFoundExcption
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card", cardId)
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)

        // 비밀번호 검사
//        if(request == commentRepository.existsByNameAndPassword)
        TODO()
        return comment.toResponse()

    }

    @Transactional
    override fun deleteComment(cardId: Long, commentId: Long) {
        // 이름과 비밀번호가 저장된 값과 일치하지 않는다면 throw unauthorizedAccess
        //DB 에서 id 에 해당하는 카드의 댓글을 가져와서 삭제
        val card = cardRepository.findByIdOrNull(cardId) ?: throw ModelNotFoundException("Card", cardId)
        val comment: Comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", cardId)

        // 비밀번호 검사


        // 삭제 후 저장, 영속성 전파
        card.removeComment(comment)
        cardRepository.save(card)
    }
}