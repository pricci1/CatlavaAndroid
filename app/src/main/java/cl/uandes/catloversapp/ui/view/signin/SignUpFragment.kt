package cl.uandes.catloversapp.ui.view.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.databinding.FragmentSignUpBinding
import cl.uandes.catloversapp.data.model.User
import cl.uandes.catloversapp.ui.view.users

class SignUpFragment : Fragment() {

  private lateinit var binding: FragmentSignUpBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = FragmentSignUpBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val signUpButton = binding.signUpButton
    val emailInput = binding.editTextSignUpEmailAddress
    val passwordInput = binding.editTextSignUpPassword

    signUpButton.setOnClickListener {
      if (emailInput.text.isNotEmpty() && passwordInput.text.isNotEmpty()) {
        if (emailDoesntExist(emailInput.text.toString())) {
          registerUser(emailInput.text.toString(), passwordInput.text.toString())
          goToSignIn()
        }
      }
    }

  }

  private fun emailDoesntExist(email: String): Boolean {
    users.find { it.email == email } ?: return true
    return false
  }

  private fun registerUser(email: String, password: String) {
    val user = User(email, password)
    users.add(user)
  }

  private fun goToSignIn() {
    findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
  }
}
