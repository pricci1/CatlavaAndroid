package cl.uandes.catloversapp.data.model

import com.google.gson.annotations.SerializedName

data class CatBreed (
  @SerializedName("name")
  val name: String,
  @SerializedName("image")
  val image: CatImage?,
  @SerializedName("temperament")
  val temperament: String,
  @SerializedName("alt_names")
  val alternativeNames: String,
)

data class CatImage (
  @SerializedName("url")
  val url: String?
)
