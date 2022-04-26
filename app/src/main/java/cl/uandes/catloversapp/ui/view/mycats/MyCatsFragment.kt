package cl.uandes.catloversapp.ui.view.mycats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.uandes.catloversapp.databinding.FragmentMyCatsBinding

class MyCatsFragment : Fragment() {

  private var _binding: FragmentMyCatsBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentMyCatsBinding.inflate(inflater, container, false)
    return binding.root
  }
}
