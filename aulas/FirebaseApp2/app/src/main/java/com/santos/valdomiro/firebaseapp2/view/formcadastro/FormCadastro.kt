package com.santos.valdomiro.firebaseapp2.view.formcadastro

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.santos.valdomiro.firebaseapp2.R
import com.santos.valdomiro.firebaseapp2.databinding.ActivityFormCadastroBinding
import com.santos.valdomiro.firebaseapp2.view.formlogin.FormLogin

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCadastrar.setOnClickListener {view ->
            val email = binding.editEmail.text.toString().trim()
            val senha = binding.editSenha.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful) {
                        val snackbar = Snackbar.make(view, "Sucesso ao cadastrar usuário", Snackbar.LENGTH_SHORT)
                        snackbar.setTextColor(Color.BLACK)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.show()

                        startActivity(Intent(this, FormLogin::class.java))
                    }
                }.addOnFailureListener {exception ->
                    val mensagemErro = when (exception) {
                        is FirebaseAuthWeakPasswordException -> "Digite um senha no mínimo 6 caracteres"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um email valido"
                        is FirebaseAuthUserCollisionException -> "Está conta já existe"
                        is FirebaseNetworkException -> "Sem conexão com a internet"
                        else -> "Erro ao cadastrar usuário"
                    }

                    val snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbar.setTextColor(Color.BLACK)
                    snackbar.setBackgroundTint(Color.YELLOW)
                    snackbar.show()
                }
            }
        }
    }
}