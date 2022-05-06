package cl.uandes.catloversapp.data.api

import cl.uandes.catloversapp.data.model.CatBreed
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatApiService(
  authToken: String = "89cd766d-b075-4248-a06f-16b9827a8291"
) : CatApi {
  private val BASE_URL = "https://api.thecatapi.com"

  private val client = OkHttpClient.Builder()
    .addInterceptor {
      val request = it.request()
      val newRequest = request.newBuilder()
        .addHeader("x-api-key", authToken)
        .build()
      it.proceed(newRequest)
    }.build()

  private val api = Retrofit.Builder()
    .baseUrl(BASE_URL) // indicamos la URL base
    .addConverterFactory(GsonConverterFactory.create())  // le decimos a retrofit como vamos a recibir la data para que la convierta
    .client(client) // con el client decimos cuales van a ser los headers
    .build()
    .create(CatApi::class.java)

  override suspend fun getCatBreeds(): Response<List<CatBreed>> = api.getCatBreeds()
}
