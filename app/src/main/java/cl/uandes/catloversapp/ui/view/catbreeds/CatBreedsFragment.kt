package cl.uandes.catloversapp.ui.view.catbreeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.databinding.FragmentCatBreedsBinding
import cl.uandes.catloversapp.model.CatBreed
import cl.uandes.catloversapp.ui.viewmodel.catbreeds.CatBreedViewModel

class CatBreedsFragment : Fragment(), CatBreedAdapter.ActionListener {

  private lateinit var binding: FragmentCatBreedsBinding
  private lateinit var catBreedAdapter: CatBreedAdapter
  private lateinit var viewModel: CatBreedViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_cat_breeds, container, false)
    viewModel = ViewModelProvider(this)[CatBreedViewModel::class.java]

    binding.lifecycleOwner = this

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.refresh()

    catBreedAdapter = CatBreedAdapter(mutableListOf(), this)

    binding.catBreedViewModel = viewModel

    binding.breedRecyclerView.apply {
      layoutManager = GridLayoutManager(context, 3)
      adapter = catBreedAdapter
    }

    observeViewModel()
  }

  private fun observeViewModel() {
    viewModel.breedsLiveData.observe(viewLifecycleOwner) { catBreeds ->
      catBreeds?.let {
        binding.breedRecyclerView.visibility = View.VISIBLE
        catBreedAdapter.updateCatBreeds(catBreeds)
      }
    }

    viewModel.loadingLiveData.observe(viewLifecycleOwner) { isLoading ->
      isLoading?.let {
        if (it) {
          binding.breedRecyclerView.visibility = View.GONE
        }
      }

    }
  }

  override fun onClick(catBreed: CatBreed) {
    val bundle = bundleOf("breed" to catBreed.name)
    findNavController().navigate(R.id.action_catBreedFragment_to_breedDetailsFragment, bundle)
  }
}
