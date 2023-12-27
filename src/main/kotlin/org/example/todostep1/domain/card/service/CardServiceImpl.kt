package org.example.todostep1.domain.card.service

import org.example.todostep1.domain.card.dto.CardResponse
import org.example.todostep1.domain.card.dto.CreateCardRequest
import org.example.todostep1.domain.card.dto.UpdateCardRequest
import org.springframework.stereotype.Service

@Service
class CardServiceImpl: CardService {
    override fun getAllCards(): List<CardResponse> {
        //DB에서 모든 card들을 가져와서 CardResponse 로 변환 후 반환
        TODO("Not yet implemented")
    }

    override fun getCard(cardId: Long): CardResponse {
        // DB에서 cardID에 해당하는 card 를 가져와서 CardReponse 로 변환 후 반환
        TODO("Not yet implemented")
    }

    override fun createCard(request: CreateCardRequest): CardResponse {
        // request를 CardResponse 로 변환 후 DB 에 저장 후 반환
        TODO("Not yet implemented")
    }

    override fun updateCard(cardId: Long, request: UpdateCardRequest): CardResponse {
        // DB 에서 cardId 에 해당하는 card 를 가져와서 request 로 업데이트 후 저장, CardReponse 로 변환 후 반환
        TODO("Not yet implemented")
    }

    override fun deleteCard(cardId: Long) {
        // DB 에서 cardId 에 해당하는 card 를 삭제
        TODO("Not yet implemented")
    }
}