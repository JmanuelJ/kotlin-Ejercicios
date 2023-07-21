package com.juanma.recyclerviewv4

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.juanma.recyclerviewv4.databinding.ItemLayoutBinding

class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
    val binding = ItemLayoutBinding.bind(itemView)
    //val rvImage: ImageView = itemView.findViewById(R.id.image)
    //val rvTitle: TextView = itemView.findViewById(R.id.title)
    val rvImage: ImageView = binding.image
    val rvTitle: TextView = binding.title
}