package com.example.demo.repository.member

import com.example.demo.dto.MemberTeamDtoConvert
import com.example.demo.entity.Member
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface MemberMapper {


    @Mappings(
        Mapping(source = "id", target = "memberId"),
        Mapping(source = "Team.id", target = "teamId"),
        Mapping(source = "Team.name", target = "teamName"),
    )
    fun toListDto(memberList: List<Member>): List<MemberTeamDtoConvert>
}