import com.example.myapplication.models.PokemonInfoResponse
import com.example.myapplication.models.PokemonListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
//    get a pokemon with id in the path
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): PokemonResponse
    @GET("pokemon?limit=1302")
    suspend fun getAllPokemon(): PokemonListResponse
}

object RetrofitPokemonInstance {
    val api: PokemonApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApiService::class.java)
    }
}