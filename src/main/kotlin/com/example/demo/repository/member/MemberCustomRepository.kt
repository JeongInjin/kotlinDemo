package com.example.demo.repository.member

import com.example.demo.dto.MemberSearchCondition
import com.example.demo.dto.MemberTeamDto
import com.example.demo.entity.Member
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface MemberCustomRepository {

//    fun selectById(id: Long): Long?
//
//    fun saveMember(member: Member)
//
//    fun deleteMember(id: Long): Boolean

    fun searchByPageImpl(condition: MemberSearchCondition, pageable: Pageable): Page<MemberTeamDto>

    fun searchByPageImplMember(condition: MemberSearchCondition, pageable: Pageable): Page<Member>
}