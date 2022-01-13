package com.example.demo.userRequest

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.Size

data class UserRequest(

    @field: NotEmpty
    @field: Size(max = 10)
    var name: String? = null,

    @field: PositiveOrZero // 0보다 큰 양수
    var age: Int? = null,

    var page: Int? = 0,
    var size: Int? = 10,

    )