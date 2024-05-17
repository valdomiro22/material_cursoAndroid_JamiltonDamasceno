package com.santos.valdomiro.appcomfirebase;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private final FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        inserirDados();
//        recuperarUsuarios();
//        cadastrarUsuario();
//        verificarSeEstaLogado();
//        loginDoUsuario();
//        deslogarUsuario();
        verificarSeEstaLogado();
    }

    public void inserirDados() {
        // Sem utilizar objetos
        reference.child("pontos").setValue("88500");
        reference.child("usuarios2").child("001").child("nome").setValue("Valdomiro");
        reference.child("usuarios2").child("001").child("idade").setValue(34);
        reference.child("usuarios2").child("002").child("nome").setValue("Jamilton");
        reference.child("usuarios2").child("002").child("idade").setValue(25);
        reference.child("usuarios2").child("003").child("nome").setValue("Camila");
        reference.child("usuarios2").child("003").child("idade").setValue(23);

        // Utilizando objetos
        DatabaseReference usuarios = reference.child("usuarios");
        Usuario usuario = new Usuario();
        usuario.setNome("Estephany");
        usuario.setSobrenome("Santos");
        usuario.setIdade(32);
        usuarios.child("001").setValue(usuario);

        DatabaseReference produtos = reference.child("produtos");
        produtos.child("001").setValue(new Produto("Televisão", "Philips", 823.29));
        produtos.child("002").setValue(new Produto("Nexus", "LG", 1259.68));
        produtos.child("003").setValue(new Produto("Acer Aspire", "Acer", 4985.89));
    }

    public void recuperarUsuarios() {
        DatabaseReference usuarios = reference.child("usuarios");
        DatabaseReference produtos = reference.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("debugador", "onDataChange: " + Objects.requireNonNull(snapshot.getValue()).toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void cadastrarUsuario() {
        // Cadastrar usuario
        usuario.createUserWithEmailAndPassword("jamilton@gmail.com", "111111")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i("debugar", "Sucesso ao cadastrar usuario");
                        } else {
                            Log.i("debugar", "Erro ao cadastrar usuario");
                        }
                    }
                });
    }

    public void verificarSeEstaLogado() {
        if (usuario.getCurrentUser() != null) {
            Log.d("debugar", "verificarSeEstaLogado: Usuario logado");
            Log.d("debugar", "verificarSeEstaLogado: " + usuario.getCurrentUser().getEmail());
        } else {
            Log.d("debugar", "verificarSeEstaLogado: Usuario não logado");
        }
    }

    public void loginDoUsuario() {
        usuario.signInWithEmailAndPassword("jamilton@gmail.com", "111111")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i("debugar", "Sucesso ao logar usuario");
                        } else {
                            Log.i("debugar", "Erro ao logar usuario");
                        }
                    }
                });
    }

    public void deslogarUsuario() {
        usuario.signOut();
    }

}