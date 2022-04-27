package cl.uandes.catloversapp.ui.viewmodel.signin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.uandes.catloversapp.data.datasources.CatLoversRoomDataSource
import cl.uandes.catloversapp.data.datasources.InMemoryDataSource
import cl.uandes.catloversapp.data.model.Users
import cl.uandes.catloversapp.data.repository.CatLoversRepository

class LoginViewModel(application: Application): AndroidViewModel(application) {

  private val repository = CatLoversRepository(
    InMemoryDataSource()
  )
  private val users = repository.getAllUsers().value
  var emailLiveData = MutableLiveData("")
  var passwordLiveData = MutableLiveData("")
  var credentialsAreValid : MutableLiveData<Boolean> = MutableLiveData()


  fun verifyUser() {
    val user = users?.find { it.email == emailLiveData.value }

    if (user?.password == passwordLiveData.value) {
      credentialsAreValid.value = true
      return
    }
    credentialsAreValid.value = false
  }

  fun isValidEmail(email: String) : Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
  }
}
