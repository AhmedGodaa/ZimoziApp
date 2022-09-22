package co.zimozi.zimoziapp.domain.models

data class PlayersResponse(
    val message: String,
    val status: String,
    val data: List<Player>

)