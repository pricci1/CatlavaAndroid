package cl.uandes.catloversapp.view.catbreeds

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.model.CatBreed
import cl.uandes.catloversapp.view.catbreeds.CatBreedAdapter.ViewHolder

class CatBreedAdapter(
  private val breedList: MutableList<CatBreed>):
  RecyclerView.Adapter<ViewHolder>() {
  inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val breedImage = itemView.findViewById<ImageView>(R.id.breedImageView)
    val breedName = itemView.findViewById<TextView>(R.id.breedNameTextView)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val context = parent.context
    val inflater = LayoutInflater.from(context)

    val breedView: View = inflater.inflate(R.layout.breed_item, parent, false)

    return ViewHolder(breedView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val catBreed = breedList[position]

    holder.breedImage.setImageResource(R.drawable.ic_cat)
    holder.breedName.text = catBreed.name
  }

  override fun getItemCount(): Int {
    return breedList.size
  }
}
