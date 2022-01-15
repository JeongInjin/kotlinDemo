package com.example.demo.repository.member

import com.example.demo.dto.MemberSearchCondition
import com.example.demo.dto.MemberTeamDto
import com.example.demo.dto.QMemberTeamDto
import com.example.demo.entity.Member
import com.example.demo.entity.QMember.member
import com.example.demo.entity.QTeam.team
import com.example.demo.repository.QuerydslPageAndSortRepository
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.util.StringUtils
import javax.persistence.EntityManager


class MemberCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
    private val em: EntityManager,
) : MemberCustomRepository, QuerydslPageAndSortRepository(em, Member::class.java) {

    /**
     * -----------------------------------------------------
     *               BCG ProtoType Example
     * -----------------------------------------------------
     */

    override fun searchByPageImpl(condition: MemberSearchCondition, pageable: Pageable): Page<MemberTeamDto> {

        val query: JPAQuery<MemberTeamDto> = queryFactory
            .select(QMemberTeamDto(
                member.id,
                member.username,
                member.age,
                team.id,
                team.name
            ))
            .from(member)
            .leftJoin(member.team, team)
            .where(
                usernameEq(condition.username),
                teamNameEq(condition.teamName),
                ageGoe(condition.ageGoe),
                ageLoe(condition.ageLoe)
            )

        return super.getPageImpl(pageable, query)
    }


    override fun searchByPageImplMember(condition: MemberSearchCondition, pageable: Pageable): Page<Member> {

        val query: JPAQuery<Member> = queryFactory
            .select(member)
            .from(member)
            .leftJoin(member.team, team)
            .where(
                usernameEq(condition.username),
                teamNameEq(condition.teamName),
                ageGoe(condition.ageGoe),
                ageLoe(condition.ageLoe)
            )

        return super.getPageImpl(pageable, query)
    }


    /*--------------------------------------------------------------------------------------------*/

    private fun usernameEq(username: String?): BooleanExpression? {
        return if (StringUtils.hasText(username)) member.username.eq(username) else null
    }

    private fun teamNameEq(teamName: String?): BooleanExpression? {
        return if (StringUtils.hasText(teamName)) team.name.eq(teamName) else null
    }

    private fun ageGoe(ageGoe: Int?): BooleanExpression? {
        return if (ageGoe != null) member.age.goe(ageGoe) else null
    }

    private fun ageLoe(ageLoe: Int?): BooleanExpression? {
        return if (ageLoe != null) member.age.loe(ageLoe) else null
    }

}

//    override fun searchPageComplex(condition: MemberSearchCondition, pageable: Pageable): Page<MemberTeamDto?> {
//        val content = queryFactory
//            .select(QMemberTeamDto(
//                member.id,
//                member.username,
//                member.age,
//                team.id,
//                team.name
//            ))
//            .from(member)
//            .leftJoin(member.team, team)
//            .where(
//                usernameEq(condition.username),
//                teamNameEq(condition.teamName),
//                ageGoe(condition.ageGoe),
//                ageLoe(condition.ageLoe)
//            )
//            .offset(pageable.offset)
//            .limit(pageable.pageSize.toLong())
//            .fetch() as List<MemberTeamDto?>
//
//        for (memberTeamDto in content) {
//            println("memberTeamDto *****************************************************= ${memberTeamDto}")
//        }
//        val count = queryFactory
//            .select(member)
//            .from(member)
//            .leftJoin(member.team, team)
//            .where(
//                usernameEq(condition.username),
//                teamNameEq(condition.teamName),
//                ageGoe(condition.ageGoe),
//                ageLoe(condition.ageLoe)
//            )
//            .offset(pageable.offset)
//            .limit(pageable.pageSize.toLong())
//            .fetch()
//
//        val total = count.size.toLong()
//
//        return PageImpl(content, pageable, total)
//    }


//    override fun searchPageComplexImproved(
//        condition: MemberSearchCondition,
//        pageable: Pageable,
//    ): Page<MemberTeamDto?>? {
//        println("==============================================================================")
//        println("condition ======================= ${condition}")
//        println("pageable ======================== ${pageable}")
//        val content = queryFactory
////            .select(QMemberTeamDto(
////                member.id,
////                member.username,
////                member.age,
////                team.id,
////                team.name
////            ))
//            .select(member)
//            .from(member)
//            .leftJoin(member.team, team)
//            .fetchJoin()
////            .where(
////                usernameEq(condition.username.toString()),
////                teamNameEq(condition.teamName.toString()),
////                ageGoe(condition.ageGoe),
////                ageLoe(condition.ageLoe)
////            )
//            .offset(pageable.offset)
//            .limit(pageable.pageSize.toLong())
//            .fetch() as List<MemberTeamDto>
//
//        val countQuery: JPAQuery<Member> = queryFactory
//            .select(member)
//            .from(member)
//            .leftJoin(member.team, team)
////            .where(
////                condition.username?.let { usernameEq(it) },
////                condition.teamName?.let { teamNameEq(it) },
////                ageGoe(condition.ageGoe),
////                ageLoe(condition.ageLoe)
////            )
//
//        println("countQuery.fetch().size.toLong() = ${countQuery.fetch().size.toLong()}")
//
//        return PageImpl(content, pageable, countQuery.fetch().size.toLong())
//    }