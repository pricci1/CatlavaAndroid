package cl.uandes.catloversapp.view.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.databinding.FragmentLoginBinding
import cl.uandes.catloversapp.model.User
import cl.uandes.catloversapp.model.Users
import cl.uandes.catloversapp.view.isLoggedIn

class LoginFragment : Fragment() {

  private var _binding: FragmentLoginBinding? = null
  private val binding get() = _binding!!
  private val users = Users.createUserList()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentLoginBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val emailInput = binding.editTextEmailAddress
    val passwordInput = binding.editTextPassword
    val loginButton = binding.loginButton

    loginButton.setOnClickListener {
      var verifiedCredentials: Boolean? = null

      if (emailInput.text.toString().isNotEmpty() && passwordInput.text.toString().isNotEmpty()) {
        verifiedCredentials = verifyUser(emailInput.text.toString(), passwordInput.text.toString())

        if (verifiedCredentials) {
          isLoggedIn = true
          findNavController().navigate(R.id.action_loginFragment_to_catBreedFragment)
          val bottomNavigationView = activity?.findViewById<View>(R.id.bottom_navigation_view)
          bottomNavigationView?.visibility = View.VISIBLE
        } else {
          Toast.makeText(context, "Credenciales inválidas", Toast.LENGTH_LONG).show()
          // aca verificar si existe el mail
          if (emailDoesntExist(emailInput.text.toString())) {
            registerUser(emailInput.text.toString(), passwordInput.text.toString())
          }
        }

      }
    }
  }

  private fun emailDoesntExist(email: String): Boolean {
    users.find { it.email == email } ?: return true
    return false
  }

  private fun verifyUser(email: String, password: String) : Boolean {
    val user = users.find { it.email == email }

    if (user?.password == password) {
      return true
    }
    return false
  }

  private fun registerUser(email: String, password: String) {
    val user = User(email, password)
    users.add(user)
  }

}
