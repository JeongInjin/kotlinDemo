package com.example.demo.controller

import com.example.demo.entity.Member
import com.example.demo.entity.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct
import javax.persistence.EntityManager


@Component
@Profile("local")
class InitMember @Autowired constructor(
    val initMemberService: InitMemberService,
) {
    @PostConstruct
    fun init() {
        initMemberService.init()
    }
}

@Component
class InitMemberService @Autowired constructor(
    @javax.persistence.PersistenceContext val em: EntityManager,
) {
    @Transactional
    fun init() {
        val teamA = Team(name = "teamA")
        val teamB = Team(name = "teamB")
        em.persist(teamA)
        em.persist(teamB)

        for (i in 0..99) {
            val selectedTeam: Team = if (i % 2 == 0) teamA else teamB
            em.persist(Member(username = "member$i", age = i, team = selectedTeam))
        }
    }
}

