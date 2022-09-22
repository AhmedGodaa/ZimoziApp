package co.zimozi.zimoziapp.domain.repos

import co.zimozi.zimoziapp.domain.models.PlayersResponse
import retrofit2.Response


interface DataRepo {
    suspend fun getData(): Response<PlayersResponse>
}