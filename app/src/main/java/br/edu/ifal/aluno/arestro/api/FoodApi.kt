import br.edu.ifal.aluno.arestro.model.food.Food
import retrofit2.http.GET

interface FoodApi {
    @GET("foods")
    suspend fun getFoods(): List<Food>
}