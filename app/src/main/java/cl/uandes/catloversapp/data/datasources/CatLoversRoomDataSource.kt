package cl.uandes.catloversapp.data.datasources

import android.content.Context
import androidx.lifecycle.LiveData
import cl.uandes.catloversapp.data.dao.UserDao
import cl.uandes.catloversapp.data.model.User
import cl.uandes.catloversapp.data.room.CatLoversRoomDatabase

class CatLoversRoomDataSource(context: Context): CatLoversDataSource {
  private val catLoversRoomDatabase =
    CatLoversRoomDatabase.getInstance(context)

  override suspend fun createUser(user: User) =
    catLoversRoomDatabase.userDao().insertUser(user)

  override suspend fun updateUser(user: User) =
    catLoversRoomDatabase.userDao().updateUser(user)

  override suspend fun deleteUser(user: User) =
    catLoversRoomDatabase.userDao().deleteUser(user)

  override fun getAllUsers() : LiveData<List<User>> =
    catLoversRoomDatabase.userDao().getAllUsers()
}
