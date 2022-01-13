package com.example.demo.controller

import com.example.demo.dto.MemberSearchCondition
import com.example.demo.dto.MemberTeamDto
import com.example.demo.entity.Member
import com.example.demo.repository.member.MemberMapper
import com.example.demo.repository.member.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController @Autowired constructor(
    var memberRepository: MemberRepository,
    private val memberMapper: MemberMapper,
) {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello Kotlin"
    }

    @GetMapping("/v1/members")
    fun searchMemberV1(condition: MemberSearchCondition, pageable: Pageable): Page<MemberTeamDto> {
        return memberRepository.searchByPageImpl(condition, pageable)
    }

    //TODO : Member Entity -> MemberTeamDTO 변환 작업해야함
    //아래 memberMapper.toListDto 로 변환은 되지만 제대로 안됨..-,.-..하아..어렵구먼~
    @GetMapping("/v2/members")
    fun searchMemberV2(condition: MemberSearchCondition, pageable: Pageable): Page<Member> {
        var pageResponse: Page<Member> = memberRepository.searchByPageImplMember(condition, pageable)

        val memberContent: List<Member> = pageResponse.content


//        for (member in memberContent) {
//            println("member 1111111111111111 1 1 1 1 ${member}")
//        }
//        var result: List<MemberTeamDto> = memberMapper.toListDto(memberContent)
//
//        result?.let {
//            for (memberTeamDto in result) {
//                println("memberTeamDto  2 2 2 2 2 2 2 2 22 2 2 22 2 2 2 = ${memberTeamDto}")
//            }
//
//        }


        return memberRepository.searchByPageImplMember(condition, pageable)


//        return memberRepository.searchByPageImplMember(condition, pageable)


    }

//    @GetMapping("/v3/members")
//    fun searchMemberV3(condition: MemberSearchCondition, pageable: Pageable): Page<MemberTeamDto?> {
//        return memberRepository.searchPageComplex(condition, pageable)
//    }
//
//    @GetMapping("/v4/members")
//    fun searchMemberAll(condition: MemberSearchCondition, pageable: Pageable): Page<MemberTeamDto?>? {
//        return memberRepository.searchPageComplexImproved(condition, pageable)
//    }
}