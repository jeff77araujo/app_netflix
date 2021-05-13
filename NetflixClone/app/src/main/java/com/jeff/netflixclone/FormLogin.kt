package com.jeff.netflixclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.jeff.netflixclone.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        verifyLoginUser()

        binding.textRegister.setOnClickListener {
            startActivity(Intent(this, FormRegister::class.java))
        }

        binding.btnEnter.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val messageError = binding.messageError

            if (email.isEmpty() || password.isEmpty()) {
                messageError.text = "Preencha todos os campos!"
            } else {
                authenticateUser()
            }
        }
    }

    private fun authenticateUser() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()
        val messageError = binding.messageError

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show()
                    goToListMovies()
                }
            }.addOnFailureListener {

            val error = it

            when {
                error is FirebaseAuthInvalidCredentialsException -> messageError.text = "E-mail ou Senha estão incorretos"
                error is FirebaseNetworkException -> messageError.text = "Sem conexão com a internet!"
                else -> messageError.text = "Erro ao cadastrar usuário"
            }

        }

    }

    private fun verifyLoginUser() {
        val userLogin = FirebaseAuth.getInstance().currentUser

        if (userLogin != null) {
            goToListMovies()
        }
    }

    private fun goToListMovies() {
        startActivity(Intent(this, ListMovies::class.java))
        finish()
    }
}