package cl.uandes.catloversapp.data.repository

import androidx.lifecycle.LiveData
import cl.uandes.catloversapp.data.api.CatApi
import cl.uandes.catloversapp.data.datasources.CatLoversDataSource
import cl.uandes.catloversapp.data.model.CatBreed
import cl.uandes.catloversapp.data.model.User

class CatLoversRepository (
    private val localDataSource: CatLoversDataSource,
    private val remoteDataSource: CatApi? = null
  ): UserRepository, CatRepository {

  override suspend fun createUser(user: User) {
    localDataSource.createUser(user)
  }

  override suspend fun updateUser(user: User) {
    localDataSource.updateUser(user)
  }

  override suspend fun deleteUser(user: User) {
    localDataSource.deleteUser(user)
  }

  override fun getAllUsers(): LiveData<List<User>> {
    return localDataSource.getAllUsers()
  }

  override suspend fun getCatBreeds(): List<CatBreed> {
    remoteDataSource?.getCatBreeds().also {
      if(it?.isSuccessful == true) {
        val breeds = it.body() ?: emptyList()
        return breeds.map { breed ->
          breed.toModel()
        }
      }
    }

    return emptyList()
  }
}
