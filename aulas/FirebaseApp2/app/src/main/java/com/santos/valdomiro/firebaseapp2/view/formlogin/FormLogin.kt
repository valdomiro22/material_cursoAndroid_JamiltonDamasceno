package com.santos.valdomiro.firebaseapp2.view.formlogin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.santos.valdomiro.firebaseapp2.R
import com.santos.valdomiro.firebaseapp2.databinding.ActivityFormLoginBinding
import com.santos.valdomiro.firebaseapp2.view.formcadastro.FormCadastro
import com.santos.valdomiro.firebaseapp2.view.telaprincipal.TelaPrincipal
import com.santos.valdomiro.firebaseapp2.view.util.TAG

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogar.setOnClickListener {view ->
            val email = binding.editEmail.text.toString().trim()
            val senha = binding.editSenha.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
                    if (autenticacao.isSuccessful) {
                        navegarParaTelaPrincipal()
                    }
                }.addOnFailureListener {
                    val snackbar = Snackbar.make(view, "Erro ao fazer login", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                    Log.e(TAG, "Email: $email", )
                    Log.e(TAG, "Senha: $senha", )
                }
            }
        }

        binding.txtLinkCadastrar.setOnClickListener {
            startActivity(Intent(this, FormCadastro::class.java))
        }

    }

    private fun navegarParaTelaPrincipal() {
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null) {
            navegarParaTelaPrincipal()
        }
    }
}