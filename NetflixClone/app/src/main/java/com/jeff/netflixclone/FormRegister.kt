package com.jeff.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.jeff.netflixclone.databinding.ActivityFormRegisterBinding

class FormRegister : AppCompatActivity() {

    private lateinit var binding: ActivityFormRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()


        binding.btnRegister.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val messageError = binding.messageError

            if (email.isEmpty() || password.isEmpty()) {
                messageError.setText("Preencha todos os campos!")
            } else {
                registerUser()
            }
        }
    }

    private fun registerUser() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()
        val messageError = binding.messageError

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                binding.editEmail.setText("")
                binding.editPassword.setText("")
                messageError.text = ""
            }
        }.addOnFailureListener {
            messageError.text = "Erro ao cadastrar usuário"
        }

    }

}