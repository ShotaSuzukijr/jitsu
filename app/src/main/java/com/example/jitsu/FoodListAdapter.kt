package com.example.jitsu

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val memoPriceView: TextView = itemView.findViewById(R.id.foodPrice)
        val memoTimeView: TextView = itemView.findViewById(R.id.foodTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return FoodViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val current = photos[position]
        holder.memoImageView.text = current.memo
        holder.memoPriceView.text = current.price
        holder.memoTimeView.text = current.time
        holder.photoItemView.setImageURI(Uri.parse(current.uri))


    }

    internal fun setPhotos(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged ()
    }

    override fun getItemCount() = photos.size
}