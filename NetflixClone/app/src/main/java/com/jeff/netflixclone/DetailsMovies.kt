package com.jeff.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jeff.netflixclone.databinding.ActivityDetailsMoviesBinding

class DetailsMovies : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}