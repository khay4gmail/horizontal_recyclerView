package com.example.horizontallistview

import android.graphics.Color
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CardsAdapter(val imagesList: IntArray, val textList: Array<String>): RecyclerView.Adapter<CardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_carosal, parent,false)

        return CardsViewHolder(itemView)
    }

    override fun getItemCount(): Int = imagesList.size

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {

        holder.imageView.setImageResource(imagesList[position])
        holder.textView.text = textList[position]
    }
}

class CardsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    var imageView = view.findViewById<ImageView>(R.id.card_imageView)
    var textView = view.findViewById<TextView>(R.id.img_textView)

}