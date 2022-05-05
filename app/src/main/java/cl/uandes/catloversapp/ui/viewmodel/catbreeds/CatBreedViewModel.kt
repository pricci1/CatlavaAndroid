package cl.uandes.catloversapp.ui.viewmodel.catbreeds

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.catloversapp.data.api.CatApiService
import cl.uandes.catloversapp.data.datasources.InMemoryDataSource
import cl.uandes.catloversapp.data.model.CatBreed
import cl.uandes.catloversapp.data.model.CatBreeds
import cl.uandes.catloversapp.data.repository.CatLoversRepository
import kotlinx.coroutines.launch

class CatBreedViewModel(application: Application): AndroidViewModel(application) {

  private val repository = CatLoversRepository(
    InMemoryDataSource(), CatApiService()
  )

  val breedTitle = MutableLiveData("Cat Breeds")
  internal val breedsLiveData = MutableLiveData<List<CatBreed>>()
  internal val loadingLiveData = MutableLiveData(true)

  fun refresh() {
    loadCatBreeds()
    loadingLiveData.value = false
  }

  private fun loadCatBreeds() {
    viewModelScope.launch {
      breedsLiveData.postValue(repository.getCatBreeds())
    }
  }
}
