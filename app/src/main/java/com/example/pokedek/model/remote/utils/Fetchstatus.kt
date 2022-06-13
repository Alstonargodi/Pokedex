package com.example.pokedek.model.remote.utils

sealed class Fetchstatus <out R> private constructor(){
    data class Sucess<out T>(val data: T): Fetchstatus<T>()
    data class Error(val error : String): Fetchstatus<Nothing>()
    object Loading : Fetchstatus<Nothing>()
}