package com.example.dictionary

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{word}?")
    fun getDefinition(@Path("word") word:String, @Query("key") key:String) : Call<List<AppShortdef>>
}