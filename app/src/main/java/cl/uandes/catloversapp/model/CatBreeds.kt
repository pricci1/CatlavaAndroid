package cl.uandes.catloversapp.model

class CatBreeds {
  companion object {
    fun getBreeds() : ArrayList<CatBreed> {
      val breeds = ArrayList<CatBreed>()
      breeds.add(CatBreed("Persa", null, "", ""))
      breeds.add(CatBreed("Bengala", null, "", ""))
      breeds.add(CatBreed("Siamés", null, "", ""))
      breeds.add(CatBreed("Doméstico", null, "", ""))
      breeds.add(CatBreed("Común de pelo corto", null, "", ""))
      breeds.add(CatBreed("Siberiano", null, "", ""))

      return breeds
    }

  }
}
