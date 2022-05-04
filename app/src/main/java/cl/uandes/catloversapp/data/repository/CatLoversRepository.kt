package cl.uandes.catloversapp.data.repository

import androidx.lifecycle.LiveData
import cl.uandes.catloversapp.data.dao.UserDao
import cl.uandes.catloversapp.data.datasources.CatLoversDataSource
import cl.uandes.catloversapp.data.model.User

class CatLoversRepository (
    private val localDataSource: CatLoversDataSource
  ): UserRepository {
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
}
