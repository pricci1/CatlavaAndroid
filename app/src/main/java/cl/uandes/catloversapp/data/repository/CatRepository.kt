package cl.uandes.catloversapp.data.repository

import cl.uandes.catloversapp.data.model.CatBreed

interface CatRepository {
  suspend fun getCatBreeds(): List<CatBreed>
}
