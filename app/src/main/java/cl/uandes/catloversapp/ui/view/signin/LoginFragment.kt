package cl.uandes.catloversapp.ui.view.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.databinding.FragmentLoginBinding
import cl.uandes.catloversapp.ui.view.isLoggedIn
import cl.uandes.catloversapp.ui.view.users
import cl.uandes.catloversapp.ui.viewmodel.signin.LoginViewModel

class LoginFragment : Fragment() {

  private lateinit var binding: FragmentLoginBinding
  private lateinit var viewModel: LoginViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_login, container, false)

    binding.lifecycleOwner = this

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.loginViewModel = viewModel

    val signUpButton = binding.signUpButton

    signUpButton.setOnClickListener {
      goToSignUp()
    }

    observeViewModel()
  }



  private fun observeViewModel() {
    viewModel.credentialsAreValid.observe(viewLifecycleOwner) { areValid ->
      areValid?.let {
        if (it) {
          isLoggedIn = true
          findNavController().navigate(R.id.catlover_navigation)
          val bottomNavigationView = activity?.findViewById<View>(R.id.bottom_navigation_view)
          bottomNavigationView?.visibility = View.VISIBLE
        } else {
          Toast.makeText(context, "Credenciales inválidas", Toast.LENGTH_LONG).show()
        }
      }
    }

    viewModel.emailLiveData.observe(viewLifecycleOwner) { email ->
      email?.let {
        if (!viewModel.isValidEmail(it) && email.isNotEmpty()) {
          binding.emailErrorTextView.visibility = View.VISIBLE
        } else {
          binding.emailErrorTextView.visibility = View.GONE
        }
      }
    }
  }

  private fun goToSignUp() {
    findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
  }
}
