package cl.uandes.catloversapp.data.datasources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.uandes.catloversapp.data.model.User
import cl.uandes.catloversapp.data.model.Users

class InMemoryDataSource: CatLoversDataSource {
  private val users = Users.createUserList()

  override suspend fun createUser(user: User) {
    users.add(user)
  }

  override suspend fun updateUser(user: User) {

  }

  override suspend fun deleteUser(user: User) {

  }

  override fun getAllUsers(): LiveData<List<User>> {
    return MutableLiveData(this.users)
  }
}
