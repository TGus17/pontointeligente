package com.oliva.pontointeligente.response

data class Response<T> (
    val erros: ArrayList<String> = arrayListOf(),
    var data: T? = null
)