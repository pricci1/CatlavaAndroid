package cl.uandes.catloversapp.ui.view.catbreeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.data.model.CatBreed
import cl.uandes.catloversapp.ui.view.catbreeds.CatBreedAdapter.ViewHolder
import com.bumptech.glide.Glide

class CatBreedAdapter(
  private val breedList: MutableList<CatBreed>,
  private val actionListener: ActionListener
  ):
  RecyclerView.Adapter<ViewHolder>() {

  inner class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private val breedImage: ImageView = itemView.findViewById(R.id.breedImageView)
    private val breedName: TextView = itemView.findViewById(R.id.breedNameTextView)
    private var currentBreed: CatBreed? = null

    init {
      itemView.setOnClickListener{
        currentBreed?.let {
          actionListener.onClick(it)
        }
      }
    }

    fun bind(catBreed: CatBreed) {
      currentBreed = catBreed

      breedName.text = currentBreed!!.name

      if (currentBreed!!.imageUrl != null) {
        Glide.with(itemView).load(currentBreed!!.imageUrl).into(breedImage)
      } else {
        breedImage.setImageResource(R.drawable.ic_cat)
      }

    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val context = parent.context
    val inflater = LayoutInflater.from(context)

    val breedView: View = inflater.inflate(R.layout.breed_item, parent, false)

    return ViewHolder(breedView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val catBreed = breedList[position]

    holder.bind(catBreed)
  }

  override fun getItemCount(): Int {
    return breedList.size
  }

  fun updateCatBreeds(catBreeds: List<CatBreed>) {
    breedList.clear()
    breedList.addAll(catBreeds)

    notifyDataSetChanged()
  }

  interface ActionListener {
    fun onClick(catBreed: CatBreed)
  }
}
