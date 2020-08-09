package com.example.horizontallistview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MoviesAdapter(val moviesList: List<MoviesModel>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent,false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.genre.text = movie.genre
        holder.year.text = movie.year

        holder.itemView.setBackgroundColor(randomColor())
    }

    fun randomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

}

class MoviesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var title: TextView = view.findViewById(R.id.title_tv)
    var genre: TextView = view.findViewById(R.id.genre_tv)
    var year: TextView = view.findViewById(R.id.year_tv)
}
