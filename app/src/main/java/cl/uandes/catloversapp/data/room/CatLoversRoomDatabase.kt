package cl.uandes.catloversapp.data.room

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import cl.uandes.catloversapp.data.dao.UserDao
import cl.uandes.catloversapp.data.model.User

@Database(
  entities = [User::class],
  version = 1
)
abstract class CatLoversRoomDatabase: RoomDatabase() {

  abstract fun userDao(): UserDao

  companion object {
    private const val DATABASE_NAME = "catlovers.db"
    private var INSTANCE: CatLoversRoomDatabase? = null

    private fun create(context: Context): CatLoversRoomDatabase =
      Room.databaseBuilder(
        context,
        CatLoversRoomDatabase::class.java,
        DATABASE_NAME
      ).fallbackToDestructiveMigration()
       .build()

    fun getInstance(context: Context): CatLoversRoomDatabase =
      (INSTANCE?: create(context).also { INSTANCE = it })
  }

  override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
    TODO("Not yet implemented")
  }

  override fun createInvalidationTracker(): InvalidationTracker {
    TODO("Not yet implemented")
  }

  override fun clearAllTables() {
    TODO("Not yet implemented")
  }
}
