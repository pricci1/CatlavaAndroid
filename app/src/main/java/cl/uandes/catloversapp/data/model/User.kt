package cl.uandes.catloversapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
  @PrimaryKey(autoGenerate = false)
  val email: String,
  @ColumnInfo(name="password")
  val password: String,
)
