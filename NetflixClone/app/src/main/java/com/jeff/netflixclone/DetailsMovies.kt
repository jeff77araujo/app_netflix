package com.jeff.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.jeff.netflixclone.adapter.MoviesAdapter
import com.jeff.netflixclone.databinding.ActivityDetailsMoviesBinding
import com.jeff.netflixclone.model.addMovies
import com.squareup.picasso.Picasso

class DetailsMovies : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        toolbar()

        val recyclerOthersMovies = binding.recyclerOthersMovies
        recyclerOthersMovies.adapter = MoviesAdapter(addMovies())
        recyclerOthersMovies.layoutManager = GridLayoutManager(applicationContext, 3)

        val coverTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-clone-23b4c.appspot.com/o/video.jpg?alt=media&token=473e8a43-ce47-41a9-8d9a-b86d52f19bd5"
        Picasso.get().load(coverTheWitcher).fit().into(binding.cover)

        binding.playMovies.setOnClickListener {
            startActivity(Intent(this, Video::class.java))
        }
    }

    private fun toolbar() {
        val toolbarDetails = binding.toolbarDetails
        toolbarDetails.navigationIcon = getDrawable(R.drawable.ic_back)
        toolbarDetails.setNavigationOnClickListener {
            startActivity(Intent(this, ListMovies::class.java))
            finish()
        }
    }
}