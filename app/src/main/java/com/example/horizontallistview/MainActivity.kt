package com.example.horizontallistview

import android.os.Bundle
import android.util.Log
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val MOVIE: String = "Movie"
    private val TABLE: String = "Table"

    private val movieList = ArrayList<MoviesModel>()
    private var timesTableList = ArrayList<String>()

    private val imagesList = intArrayOf(R.drawable.plane1,
        R.drawable.plane2,
        R.drawable.plane3,
        R.drawable.plane4,
        R.drawable.plane5,
        R.drawable.plane6,
        R.drawable.plane7,
        R.drawable.plane8,
        R.drawable.plane9,
        R.drawable.plane10,
        R.drawable.plane11,
        R.drawable.plane12,
        R.drawable.plane13,
        R.drawable.plane14,
        R.drawable.plane15,
        R.drawable.plane16,
        R.drawable.plane17,
        R.drawable.plane18,
        R.drawable.plane19,
        R.drawable.plane20
    )
    private val textList = arrayOf("1 X 1 =1",
        "2 X 1 =2",
        "3 X 1 =3",
        "4 X 1 =4",
        "5 X 1 =5",
        "6 X 1 =6",
        "7 X 1 =7",
        "8 X 1 =8",
        "9 X 1 =9",
        "10 X 1 =10",
        "11 X 1 =11",
        "12 X 1 =12",
        "13 X 1 =13",
        "14 X 1 =14",
        "15 X 1 =15",
        "16 X 1 =16",
        "17 X 1 =17",
        "18 X 1 =18",
        "19 X 1 =19",
        "20 X 1 =20"
    )

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var cardsAdapter: CardsAdapter
    private lateinit var tablesAdapter: TablesAdapter

    var carosalVisibleViewPosition: Int = 0
    var initialLoad = true

    lateinit var carosalRecyclerview: RecyclerView
    lateinit var tableRecyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"

        carosalRecyclerview = findViewById<RecyclerView>(R.id.recyclerView_top)
        tableRecyclerview = findViewById<RecyclerView>(R.id.recyclerView_bottom)

        setupCarosalView()
        tablesAdapter = TablesAdapter(timesTableList)
        tableRecyclerview.adapter = tablesAdapter
        val tableLayoutmanger = LinearLayoutManager(applicationContext)
        tableRecyclerview.layoutManager = tableLayoutmanger
        tableRecyclerview.itemAnimator = DefaultItemAnimator()

        prepareTableDate()
//        setupTableViewFor(TABLE)
    }

    fun setupCarosalView() {
        cardsAdapter = CardsAdapter(imagesList, textList)
        val carosalLayoutmanger = CenterScaleLinearLayoutManager(applicationContext)
        carosalLayoutmanger.orientation = LinearLayoutManager.HORIZONTAL
        carosalRecyclerview.layoutManager = carosalLayoutmanger
        carosalRecyclerview.itemAnimator = DefaultItemAnimator()
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(carosalRecyclerview)
        addCarosalRecyclerViewListnerFor(carosalRecyclerview, carosalLayoutmanger)
        carosalRecyclerview.adapter = cardsAdapter
    }

    fun setupTableViewFor(type: String = MOVIE) {

        if (type == MOVIE) {
            moviesAdapter = MoviesAdapter(movieList)
            tableRecyclerview.adapter = moviesAdapter

            prepareMovieData()
        } else {
            tablesAdapter = TablesAdapter(timesTableList)
            tableRecyclerview.adapter = tablesAdapter

            prepareTableDate()
        }


        val tableLayoutmanger = LinearLayoutManager(applicationContext)
        tableRecyclerview.layoutManager = tableLayoutmanger
        tableRecyclerview.itemAnimator = DefaultItemAnimator()
    }

    private fun addCarosalRecyclerViewListnerFor(customRecyclerView: RecyclerView, customLayoutManager: LinearLayoutManager) {
        customRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {

            override fun onScrolled(@NonNull recyclerView:RecyclerView, dx:Int, dy:Int) {
                super.onScrolled(recyclerView, dx, dy)
                carosalVisibleViewPosition = customLayoutManager.findFirstVisibleItemPosition()
                carosalVisibleViewPosition += 1
                Log.d("VisiblePosition", "$carosalVisibleViewPosition")
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d("ScrollState", newState.toString())

                if (newState == 0){
                    prepareTableDate(carosalVisibleViewPosition)
                }
            }
        })
    }

    fun prepareTableDate(index: Int = 1) {
        timesTableList.clear()
        for (i in 1..12) {
            timesTableList.add(index.toString() + " X " + i.toString() + " = " + (i * index).toString())
        }
        Log.d("timesTableContent", "$timesTableList")
        tablesAdapter.notifyDataSetChanged()
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
}