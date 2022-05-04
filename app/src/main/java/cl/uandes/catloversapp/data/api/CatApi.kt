package cl.uandes.catloversapp.data.api

import cl.uandes.catloversapp.data.model.CatBreed
import retrofit2.http.GET
import retrofit2.Response
// import retrofit2.http.Path

interface CatApi {
  @GET("v1/breeds")
  suspend fun getCatBreeds(): Response<List<CatBreed>>

  // Si quieren mandar un parametro al path
  // @GET("breeds/{breed_id}")
  // suspend fun getCatBreedById(@Path("breed_id") breedId: String): Response<CatBreed>
}
