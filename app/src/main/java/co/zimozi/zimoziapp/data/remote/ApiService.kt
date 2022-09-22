package co.zimozi.zimoziapp.data.remote


import co.zimozi.zimoziapp.domain.models.PlayersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("Demonuts/JsonTest/Tennis/json_parsing.php")
    suspend fun getProducts(): Response<PlayersResponse>

}