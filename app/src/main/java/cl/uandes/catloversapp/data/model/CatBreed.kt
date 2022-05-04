package cl.uandes.catloversapp.data.model

import androidx.annotation.DrawableRes

data class CatBreed (
  val name: String,
  @DrawableRes
  val image: Int?,
  val description: String,
  val colors: String,
)
