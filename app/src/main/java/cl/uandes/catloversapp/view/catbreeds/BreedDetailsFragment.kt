package cl.uandes.catloversapp.view.catbreeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.databinding.FragmentBreedDetailsBinding

class BreedDetailsFragment : Fragment() {

  private var _binding: FragmentBreedDetailsBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    _binding = FragmentBreedDetailsBinding.inflate(inflater, container, false)
    return binding.root
  }
}
