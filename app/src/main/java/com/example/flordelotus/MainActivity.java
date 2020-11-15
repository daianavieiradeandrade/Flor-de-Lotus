package com.example.flordelotus;
/**
 * 1. Se usuario masculino não estiver associado a nenhum convite direcionar activitie de convite
 * 2. Se usuaria femina estiver com dados menstruais em branco abrir a activitie de cadastro periodo
 * 3. Se usuario entrar como admin@gmail.com direcionar a activitie de ArticlesAdmin
 * */
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button login, register;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("E-mail é requerido.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Senha é requerida.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Seja bem vindo!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), CalendarAction.class));
                           /**
                            * admin@gmail.com
                            * senha: admin123
                            **/
                            if (email.contains("admin@gmaail.com")){
                                startActivity(new Intent(getApplicationContext(), ArticlesAdmin.class));
                            } else { startActivity(new Intent(getApplicationContext(), CalendarAction.class)); }

                        } else {
                            Toast.makeText(MainActivity.this, "Algo deu errado!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cadastro.class));
            }
        });
    }
}