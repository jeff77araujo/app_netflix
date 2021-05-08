package com.jeff.netflixclone

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.jeff.netflixclone.adapter.MoviesAdapter
import com.jeff.netflixclone.databinding.ActivityListMoviesBinding
import com.jeff.netflixclone.model.addMovies
import com.jeff.netflixclone.onclick.OnItemClickListener
import com.jeff.netflixclone.onclick.addOnItemClickListener

class ListMovies : AppCompatActivity() {

    private lateinit var binding: ActivityListMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_movies = binding.recycleView
        recycler_movies.adapter = MoviesAdapter(addMovies())
        recycler_movies.layoutManager = GridLayoutManager(applicationContext, 3)

        recycler_movies.addOnItemClickListener(object : OnItemClickListener{
            override fun onItemClicked(position: Int, view: View) {

                when {
                    position == 0 -> detailsMovies()
                    position == 1 -> detailsMovies()
                    position == 2 -> detailsMovies()
                }
            }
        })

    }

    private fun detailsMovies() {
        startActivity(Intent(this, DetailsMovies::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.logout -> {
                FirebaseAuth.getInstance().signOut()
                backLoginScreen()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun backLoginScreen() {
        startActivity(Intent(this, FormLogin::class.java))
        finish()
    }
}