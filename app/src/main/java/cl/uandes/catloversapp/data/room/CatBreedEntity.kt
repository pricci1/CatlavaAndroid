package cl.uandes.catloversapp.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.uandes.catloversapp.data.model.CatBreed

@Entity(tableName = "cat_breed")
data class CatBreedEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val temperament: String,
    val alternativeNames: String,
) {
    companion object {
        fun fromModel(breed: CatBreed): CatBreedEntity {
            // Sirve cuando uno quiere hacer POST a la api. En este caso no es necesario
            TODO("Not yet implemented")
        }
    }

    fun toModel(): CatBreed = CatBreed(name, imageUrl, temperament, alternativeNames)
}
