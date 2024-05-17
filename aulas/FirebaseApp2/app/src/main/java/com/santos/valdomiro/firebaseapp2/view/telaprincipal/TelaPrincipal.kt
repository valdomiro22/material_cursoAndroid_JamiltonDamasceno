package com.santos.valdomiro.firebaseapp2.view.telaprincipal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.santos.valdomiro.firebaseapp2.R
import com.santos.valdomiro.firebaseapp2.databinding.ActivityTelaPrincipalBinding
import com.santos.valdomiro.firebaseapp2.view.formlogin.FormLogin
import com.santos.valdomiro.firebaseapp2.view.util.TAG

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()  // Deslogar usuário
            startActivity(Intent(this, FormLogin::class.java))
        }

        binding.btnGravarDados.setOnClickListener {
            val usuariosMap = hashMapOf(
                "nome" to "Maria",
                "sobrenome" to "Da Silva",
                "idade" to 19
            )

            db.collection("usuarios").document("Maria")
                .set(usuariosMap).addOnCompleteListener {
                    Log.d(TAG, "Sucesso ao salvar os dados do usuario")
                }.addOnFailureListener {  }
        }

        binding.btnLerDados.setOnClickListener {
//            db.collection("usuarios").document("Maria")
            db.collection("usuarios").document("Marcos")
                .addSnapshotListener { documento, error ->
                    if (documento != null) {
                        binding.txtResultadoNome.text = documento.getString("nome")
                        binding.txtResultadoSobrenome.text = documento.getString("sobrenome")
                        binding.txtResultadoIdade.text = documento.getLong("idade").toString()
                    }
                }
        }

        binding.btnAtualizarDados.setOnClickListener {
            db.collection("usuarios").document("Marcos")
                .update("sobrenome", "Pereira Neves", "idade", 44)
                .addOnFailureListener {
                    Log.d(TAG, "Sucesso ao atualizar os dados do usuario")
                }
        }

        binding.btnDeletarDados.setOnClickListener {
            db.collection("usuarios").document("Marcos")
                .delete()
                .addOnFailureListener {
                    Log.d(TAG, "Sucesso ao atualizar os dados do usuario")
                }
        }
    }

}