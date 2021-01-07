package com.example.jitsu

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodListAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var photos = emptyList<Photo>()

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoItemView: ImageView = itemView.findViewById(R.id.foodImage)
        val memoImageView: TextView = itemView.findViewById(R.id.foodText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhotoViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val current = photos[position]
        holder.memoItemView.text = current.memo
        holder.photoItemView.setImageURI(Uri.parse(current.uri))
    }

    internal fun setPhotos(photos: List<Photo>) {
        this.photos = photos notifyDataSetChanged ()
    }

    override fun getItemCount() = photos.size
}