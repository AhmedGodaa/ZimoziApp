package co.zimozi.zimoziapp.data.repositories

import co.zimozi.zimoziapp.data.remote.ApiService
import co.zimozi.zimoziapp.domain.models.PlayersResponse
import co.zimozi.zimoziapp.domain.repos.DataRepo
import retrofit2.Response
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) : DataRepo {
    override suspend fun getData(): Response<PlayersResponse> {
        return apiService.getProducts()
    }
}