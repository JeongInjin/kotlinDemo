package com.example.demo.dto

import com.example.demo.entity.Member
import com.querydsl.core.annotations.QueryProjection

class MemberTeamDto @QueryProjection constructor(
    var memberId: Long? = null,
    var username: String? = null,
    var age: Int? = null,
    var teamId: Long? = null,
    var teamName: String? = null,
) {
    override fun toString(): String {
        return "MemberTeamDto(memberId=$memberId, username=$username, age=$age, teamId=$teamId, teamName=$teamName)"
    }

}

class MemberTeamDtoConvert {
    constructor(member: Member? = null) {
        this.memberId = member?.id
        this.username = member?.username
        this.age = member?.age
        this.teamId = member?.team?.id
        this.teamName = member?.team?.name
    }

    var memberId: Long? = null
    var username: String? = null
    var age: Int? = null
    var teamId: Long? = null
    var teamName: String? = null


    override fun toString(): String {
        return "MemberTeamDtoConvert(memberId=$memberId, username=$username, age=$age, teamId=$teamId, teamName=$teamName)"
    }

}


//fun MemberTeamDto.convertMember(member: Member): MemberTeamDto {
//    return MemberTeamDto().apply {
//        this.memberId = member.id
//        this.username = member.username
//        this.age = member.age
//        this.teamId = member.team?.id
//        this.teamName = member.team?.name
//    }
//}