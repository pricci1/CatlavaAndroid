package cl.uandes.catloversapp.data.model

import java.time.format.DateTimeFormatter

class Cat (
  id: String,
  user: User,
  name: String,
  birthDate: DateTimeFormatter,
  breed: CatBreed,
  image: String,
)
