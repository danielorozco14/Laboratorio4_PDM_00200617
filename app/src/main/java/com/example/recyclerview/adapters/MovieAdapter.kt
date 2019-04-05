package com.example.recyclerview.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.example.recyclerview.pojos.Movie
import kotlinx.android.synthetic.main.cardview_movie.view.*
import java.text.FieldPosition

class MovieAdapter(var movies:List<Movie>, val clickLister:(Movie)->Unit):RecyclerView.Adapter<MovieAdapter.ViewHolder> () {


    //INFLA CADA UNO DE LOS ELEMENTOS DE NUESTRA LIST EN LA VISTA
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position], clickLister)

    fun changeList(movies: List<Movie>)
    {
        this.movies=movies
        notifyDataSetChanged()
    }

    /**
     * Vista de un elemento de nuestra lista
     */
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(item:Movie, clickListener: (Movie) -> Unit)= with(itemView){
            Glide.with(itemView.context)
                .load(item.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(movie_image_cv)
            //ID'S DEL XML
            movie_title_cv.text=item.Title
            movie_plot_cv.text=item.Plot
            movie_rate_cv.text= item.imdbRating
            movie_runtime_cv.text=item.Runtime

            this.setOnClickListener{clickListener(item)}
        }

    }


}

