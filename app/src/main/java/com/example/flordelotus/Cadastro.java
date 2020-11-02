package com.example.flordelotus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    RadioButton f,m;
    EditText mFullName, mEmail, mPassword, mPasswordConfirm;
    Button btnRegister;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        f = findViewById(R.id.feminino);
        m = findViewById(R.id.masculino);
        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPasswordConfirm = findViewById(R.id.passwordConfirm);
        btnRegister = findViewById(R.id.btnRegister);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

       /*if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }*/

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mFullName.getText().toString();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String checkPassword = mPasswordConfirm.getText().toString().trim();


                if(TextUtils.isEmpty(name)){
                    mFullName.setError("Nome não pode estar em branco.");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("E-mail é requerido.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Senha é requerida.");
                    return;
                }
                if(!checkPassword.equals(password)){
                    mPasswordConfirm.setError("Senhas não coincidem");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("Senha precisa ter mais de 6 caracteres");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Cadastro.this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();
                                    if(f.isChecked()){
                                        startActivity(new Intent(getApplicationContext(), CadastroPeriodo.class));
                                    }
                                    if(m.isChecked()) {
                                        startActivity(new Intent(getApplicationContext(), InserirConvite.class));
                                    }
                                }else{
                                    Toast.makeText(Cadastro.this, "Erro!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });

             }
        });
    }
}