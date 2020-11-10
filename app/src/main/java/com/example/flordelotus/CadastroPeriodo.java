package com.example.flordelotus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CadastroPeriodo extends AppCompatActivity {

    EditText ultimoCiclo, diasCiclo, mediaCiclo;
    Button salvar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_periodo);

        ultimoCiclo = findViewById(R.id.lastPeriod);
        diasCiclo = findViewById(R.id.periodDays);
        mediaCiclo = findViewById(R.id.periodAvarage);
        salvar = findViewById(R.id.btnSave);
        progressBar = findViewById(R.id.progressBar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ultimo= ultimoCiclo.getText().toString().trim();
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
                startActivity(new Intent(getApplicationContext(), CalendarAction.class));
                Toast.makeText(CadastroPeriodo.this, "Seja Bem Vinda!", Toast.LENGTH_LONG).show();
            }
        });
    }
}