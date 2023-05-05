package com.example.ceritaku_compose.remote.utils

sealed class FetchRespon <out R> private constructor() {
    data class Sucess<out T>(val data : T): FetchRespon<T>()
    data class Error(val error : String): FetchRespon<Nothing>()
    object Loading : FetchRespon<Nothing>()
}