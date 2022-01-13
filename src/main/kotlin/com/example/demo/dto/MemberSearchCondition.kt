package com.example.demo.dto

data class MemberSearchCondition(
    val username: String? = null,
    val teamName: String? = null,
    val ageGoe: Int? = null,//크거나 같거나
    val ageLoe: Int? = null, //직가니 깉가니
)