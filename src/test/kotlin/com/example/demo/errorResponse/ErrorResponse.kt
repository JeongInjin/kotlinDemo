package com.example.demo.errorResponse

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/* ErrorResponse API
{
    "result_code": "FAIL",
    "http_status": "400",
    "http_method": "GET",
    "message": "요청에 에러가 발생하였습니다.",
    "path": "/api/exception",
    "timestamp": "2021-09-06T16:03:43.556134",
    "errors":[
        {
        "field": "name",
        "message": "크기가 2에서 6 사이여야 합니다",
        "value": "LeeJuHyun"
        }
    ]
}
*/
data class ErrorResponse(

    @field: JsonProperty("result_code")
    var resultCode: String? = null,

    @field: JsonProperty("http_status")
    var httpStatus: String? = null,

    @field: JsonProperty("http_method")
    var httpMethod: String? = null,
    var message: String? = null,
    var path: String? = null,
    var timestamp: LocalDateTime? = null,
    var errors: MutableList<Error>? = mutableListOf(),
)

data class Error(
    var field: String? = null,
    var message: String? = null,
    var value: Any? = null,
)