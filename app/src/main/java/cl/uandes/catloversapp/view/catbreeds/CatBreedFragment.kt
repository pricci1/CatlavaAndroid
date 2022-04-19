package cl.uandes.catloversapp.view.catbreeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.uandes.catloversapp.databinding.FragmentCatBreedBinding

class CatBreedFragment : Fragment() {

  private var _binding: FragmentCatBreedBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentCatBreedBinding.inflate(inflater, container, false)
    return binding.root
  }

}
