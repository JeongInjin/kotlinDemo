package com.example.demo.repository.member

import com.example.demo.dto.MemberTeamDto
import com.example.demo.entity.Member
import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface MemberMapper {


    @Mappings(
//        Mapping(source = "memberList.member_id", target = "memberId"),
//        Mapping(source = "memberList.team.team_id", target = "teamId"),
//        Mapping(source = "memberList.team.name", target = "teamName"),
    )
    fun toListDto(memberList: List<Member>): List<MemberTeamDto>
}