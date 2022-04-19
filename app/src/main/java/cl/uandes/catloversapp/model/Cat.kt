package cl.uandes.catloversapp.model

import java.time.format.DateTimeFormatter

class Cat (
  id: String,
  user: User,
  name: String,
  birthDate: DateTimeFormatter,
  breed: CatBreed,
  image: String,
)
