package com.example.demo.controller

import com.example.demo.repository.member.MemberRepository
import com.example.demo.repository.team.TeamRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import javax.persistence.EntityManager


@SpringBootTest
@WebMvcTest
internal class TestContorollerTest @Autowired constructor(
    private val em: EntityManager,
    private var queryFactory: JPAQueryFactory,
    private val teamRepository: TeamRepository,
    private val memberRepository: MemberRepository,
    private val contoroller: TestController,
) {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun helloTest() {
        val uri: String = "/api/exception/hello"
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("hello Kotlin"))
            .andDo(MockMvcResultHandlers.print())
    }

}




















