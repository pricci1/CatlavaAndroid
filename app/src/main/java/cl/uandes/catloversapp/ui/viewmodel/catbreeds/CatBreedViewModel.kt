package cl.uandes.catloversapp.ui.viewmodel.catbreeds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.uandes.catloversapp.model.CatBreed
import cl.uandes.catloversapp.model.CatBreeds

class CatBreedViewModel: ViewModel() {

  val breedTitle = MutableLiveData("Cat Breeds")
  internal val breedsLiveData = MutableLiveData<ArrayList<CatBreed>>()
  internal val loadingLiveData = MutableLiveData(true)

  fun refresh() {
    breedsLiveData.value = loadCatBreeds()
    loadingLiveData.value = false
  }

  private fun loadCatBreeds() : ArrayList<CatBreed> {
    return CatBreeds.getBreeds()
  }
}
