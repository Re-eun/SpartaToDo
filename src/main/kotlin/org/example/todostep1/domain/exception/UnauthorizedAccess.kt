package org.example.todostep1.domain.exception

data class UnauthorizedAccess(val name: String) :
    RuntimeException("이름과 비밀번호가 일치하지 않습니다. 이름: ${name}")