package com.example.pokedek.presentasion.utils

sealed class FetchResult <out R> private constructor(){
    data class Sucess<out T>(val data: T): FetchResult<T>()
    data class Error(val error : String): FetchResult<Nothing>()
    object Loading : FetchResult<Nothing>()
}
