package com.example.demo.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
class exControllerTest @Autowired constructor(
    private var mockMvc: MockMvc,
) {


    @Test
    fun hello_테스트() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/hello")
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andExpect(
            MockMvcResultMatchers.content().string("hello Kotlin")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun helloTest() {
//        val uri: String = "/api/exception/hello"
//        mockMvc.perform(MockMvcRequestBuilders.get(uri))
//            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andExpect(MockMvcResultMatchers.content().string("hello Kotlin"))
//            .andDo(MockMvcResultHandlers.print())
    }

}




















