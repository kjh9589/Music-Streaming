package com.teamnoyes.music_streaming.service

import retrofit2.Call
import retrofit2.http.GET

interface MusicService {
    @GET("/v3/7ff8ef26-192c-42c7-9a2f-dd409fe2390b")
    fun listMusics(): Call<MusicDto>
}