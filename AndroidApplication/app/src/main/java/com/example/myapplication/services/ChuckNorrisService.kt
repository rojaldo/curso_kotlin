import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ChuckNorrisApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): ChuckNorrisJoke
}

object RetrofitInstance {
    private const val BASE_URL = "https://api.chucknorris.io/"

    val api: ChuckNorrisApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckNorrisApiService::class.java)
    }
}