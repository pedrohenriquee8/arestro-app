import br.edu.ifal.aluno.arestro.main.model.FoodItem
import retrofit2.http.GET

interface FoodApi {
    @GET("foods")
    suspend fun getFoods(): List<FoodItem>
}