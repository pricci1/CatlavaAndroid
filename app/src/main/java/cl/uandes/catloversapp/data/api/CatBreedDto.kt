package cl.uandes.catloversapp.data.api

import cl.uandes.catloversapp.data.model.CatBreed
import com.google.gson.annotations.SerializedName

data class CatBreedDto (
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: CatImage?,
    @SerializedName("temperament")
    val temperament: String,
    @SerializedName("alt_names")
    val alternativeNames: String,
) {
    fun toModel(): CatBreed {
        return CatBreed(name, image?.url, temperament, alternativeNames)
    }
}

data class CatImage (
    @SerializedName("url")
    val url: String?
)
