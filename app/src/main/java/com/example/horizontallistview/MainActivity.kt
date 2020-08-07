package com.example.horizontallistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val movieList = ArrayList<MoviesModel>()
    private val imagesList = intArrayOf(R.drawable.car1,R.drawable.cockpit1,R.drawable.plane1,R.drawable.plane2,R.drawable.plane3,R.drawable.plane4)
    private val textList = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details")
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var cardsAdapter: CardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        val carosal_recyclerView = findViewById<RecyclerView>(R.id.recyclerView_top)
        val table_recyclerView = findViewById<RecyclerView>(R.id.recyclerView_bottom)
        moviesAdapter = MoviesAdapter(movieList)
        cardsAdapter = CardsAdapter(imagesList, textList)
        val carosal_layoutManger = CenterScaleLinearLayoutManager(applicationContext)
        val table_layoutManger = LinearLayoutManager(applicationContext)
        carosal_layoutManger.orientation = LinearLayoutManager.HORIZONTAL
        carosal_recyclerView.layoutManager = carosal_layoutManger
        carosal_recyclerView.itemAnimator = DefaultItemAnimator()
        table_recyclerView.layoutManager = table_layoutManger
        table_recyclerView.itemAnimator = DefaultItemAnimator()
        table_recyclerView.adapter = moviesAdapter
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(carosal_recyclerView)
        carosal_recyclerView.adapter = cardsAdapter
        prepareMovieData()
    }

    private fun prepareMovieData() {
        var movie = MoviesModel("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)
        movie = MoviesModel("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)
        movie = MoviesModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        movie = MoviesModel("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)
        movie = MoviesModel("The Martian", "Science Fiction & Fantasy", "2015")
        movieList.add(movie)
        movie = MoviesModel("Mission: Impossible Rogue Nation", "Action", "2015")
        movieList.add(movie)
        movie = MoviesModel("Up", "Animation", "2009")
        movieList.add(movie)
        movie = MoviesModel("Star Trek", "Science Fiction", "2009")
        movieList.add(movie)
        movie = MoviesModel("The LEGO MoviesModel", "Animation", "2014")
        movieList.add(movie)
        movie = MoviesModel("Iron Man", "Action & Adventure", "2008")
        movieList.add(movie)
        movie = MoviesModel("Aliens", "Science Fiction", "1986")
        movieList.add(movie)
        movie = MoviesModel("Chicken Run", "Animation", "2000")
        movieList.add(movie)
        movie = MoviesModel("Back to the Future", "Science Fiction", "1985")
        movieList.add(movie)
        movie = MoviesModel("Raiders of the Lost Ark", "Action & Adventure", "1981")
        movieList.add(movie)
        movie = MoviesModel("Goldfinger", "Action & Adventure", "1965")
        movieList.add(movie)
        movie = MoviesModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        movieList.add(movie)
        moviesAdapter.notifyDataSetChanged()
    }

    private fun prepareCardData() {

    }
}