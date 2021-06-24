package com.teamnoyes.music_streaming

data class PlayerModel(
    private val playMusicList: List<MusicModel> = emptyList(),
    var currentPosition: Int = -1,
    var isWatchingPlayListView: Boolean = true
) {
    fun getAdapterModels(): List<MusicModel> {
        return playMusicList.mapIndexed { index, musicModel ->
            // copy 수정하려는 값만 변경하고 클래스를 새로 만들어 준다
            // ListAdapter 안에 있는 값을 수정하면 새로운 값과 원래 있던 값 모두 수정된 것이기 때문에 인식하지 못 한다
            // areItemsTheSame에서 oldItem도 초기화하고 newItem도 초기화한 값이기 때문에 둘이 같은 값이라 갱신하지 않는다.
            val newItem = musicModel.copy(
                isPlaying = index == currentPosition
            )
            newItem
        }
    }

    fun updateCurrentPosition(musicModel: MusicModel) {
        currentPosition = playMusicList.indexOf(musicModel)
    }

    fun nextMusic(): MusicModel? {
        if (playMusicList.isEmpty()) return null

        currentPosition =
            if ((currentPosition + 1) == playMusicList.size) 0 else currentPosition + 1
        return playMusicList[currentPosition]
    }

    fun prevMusic(): MusicModel? {
        if (playMusicList.isEmpty()) return null

        currentPosition =
            if ((currentPosition - 1) < 0) playMusicList.lastIndex else currentPosition - 1
        return playMusicList[currentPosition]
    }

    fun currentMusicModel(): MusicModel? {
        if (playMusicList.isEmpty()) return null

        return  playMusicList[currentPosition]
    }
}
