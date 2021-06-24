package com.teamnoyes.music_streaming.service

import com.google.gson.annotations.SerializedName

// 서버에서 받은 데이터
data class MusicEntity(
    @SerializedName("track") val track: String,
    @SerializedName("streamUrl") val streamUrl: String,
    @SerializedName("artist") val artist: String,
    @SerializedName("coverUrl") val coverUrl: String
)
