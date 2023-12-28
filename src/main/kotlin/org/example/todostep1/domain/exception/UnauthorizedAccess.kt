package org.example.todostep1.domain.exception

class UnauthorizedAccess() :
    RuntimeException("이름과 비밀번호가 일치하지 않습니다.")