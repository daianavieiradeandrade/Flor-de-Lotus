package com.example.flordelotus;

/**
 * SALVAR ULTIMO PERIODO
 * SALVAR DIAS CICLO
 * SALVAR MEDIA CICLO
 * PERIODO FUTURO DE MENSTRUAÇÃO: ULTIMO PERIODO + MEDIA CICLO
 * MARCAÇÃO DE DIAS DE DURAÇÃO: PERIODO FUTURO + DIAS CICLO
 * */

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Calendar;
import java.util.Date;

public class PeriodActivity extends AppCompatActivity {

    EditText ultimoCiclo, diasCiclo, mediaCiclo;
    Button salvar;
    ProgressBar progressBar;
    String userID;

    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);

        ultimoCiclo = findViewById(R.id.ultimoPeriodo);
        diasCiclo = findViewById(R.id.duracaoDias);
        mediaCiclo = findViewById(R.id.mediaPeriodo);
        salvar = findViewById(R.id.btnSalvar);
        progressBar = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        userID = firebaseAuth.getCurrentUser().getUid();

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ultimo = ultimoCiclo.getText().toString().trim();
                String dias= diasCiclo.getText().toString().trim();
                String media= mediaCiclo.getText().toString().trim();

                if(TextUtils.isEmpty(ultimo)){
                    ultimoCiclo.setError("Informe a data.");
                    return;
                }
                if(TextUtils.isEmpty(dias)){
                    diasCiclo.setError("Informe os dias.");
                    return;
                }
                if(TextUtils.isEmpty(media)){
                    mediaCiclo.setError("Informe a média de dias.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
                Toast.makeText(PeriodActivity.this, "Seja Bem Vinda!", Toast.LENGTH_LONG).show();
            }
        });
    }
}