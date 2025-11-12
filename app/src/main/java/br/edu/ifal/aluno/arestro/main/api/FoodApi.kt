import br.edu.ifal.aluno.arestro.main.components.FoodItem
import retrofit2.http.GET

interface FoodsApi {
    @GET("best-offers")
    suspend fun getBestOffers(): List<FoodItem>
}