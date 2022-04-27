package cl.uandes.catloversapp.data.repository

import androidx.lifecycle.LiveData
import cl.uandes.catloversapp.data.model.User

interface UserRepository {
  suspend fun createUser(user: User)
  suspend fun updateUser(user: User)
  suspend fun deleteUser(user: User)
  fun getAllUsers(): LiveData<List<User>>
}
