package com.example.recyclerview.activities

import android.content.AbstractThreadedSyncAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.pojos.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewManager:RecyclerView.LayoutManager

    private var movieList:ArrayList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initSearchButton()
    }

    fun initRecyclerView(){

        //LinearLayoutManager posiciona los elementos de manera vertical
        viewManager= LinearLayoutManager(this)

        //Funcion lambda funciona como onClickListener
        movieAdapter = MovieAdapter(movieList, { movieItem: Movie -> movieItemClicked(movieItem)})

    }
}
