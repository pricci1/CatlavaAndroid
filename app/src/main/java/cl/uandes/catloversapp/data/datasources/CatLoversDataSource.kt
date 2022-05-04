package cl.uandes.catloversapp.data.datasources

import androidx.lifecycle.LiveData
import cl.uandes.catloversapp.data.model.User

interface CatLoversDataSource {
  suspend fun createUser(user: User)
  suspend fun updateUser(user: User)
  suspend fun deleteUser(user: User)
  fun getAllUsers(): LiveData<List<User>>

  // y otras funciones para las demas entities
}
