package cl.uandes.catloversapp.ui.viewmodel.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.uandes.catloversapp.model.Users

class LoginViewModel: ViewModel() {
  private val users = Users.createUserList()
  var emailLiveData = MutableLiveData("")
  var passwordLiveData = MutableLiveData("")
  var credentialsAreValid : MutableLiveData<Boolean> = MutableLiveData()


  fun verifyUser() {
    val user = users.find { it.email == emailLiveData.value }

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
