package com.teamnoyes.music_streaming

import com.teamnoyes.music_streaming.service.MusicDto
import com.teamnoyes.music_streaming.service.MusicEntity

fun MusicEntity.mapper(id: Long): MusicModel =
    MusicModel(
        id = id,
        streamUrl = streamUrl,
        coverUrl = coverUrl,
        track = track,
        artist = artist
    )

fun MusicDto.mapper(): PlayerModel =
    PlayerModel(
        playMusicList =  musics.mapIndexed { index, musicEntity ->
            musicEntity.mapper(index.toLong())
        }
    )