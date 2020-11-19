package com.example.flordelotus;

/**
 * PONTO DE NOTIFICAÇÃO DE NOTAS ADICIONADAS DO DIA
 * PONTO DE NOTIFICAÇÃO DE POSTS ADICIONADOS PELO ADMIN
 * PONTO DE NOTIFICAÇÃO DE PREVISÃO DE PEIODO MENSTRUAL
 * BLOCO SUPEIOR COM AS INFORMAÇÕES DOS PROXIMOS CICLOS E NOTAS DAQUELE DIA
 * A ULTIMA MENSTRUAÇÃO CADASTRADA PELA USUARIA NO "PERIODACTIVITY" DEVERÁ SER MOSTRADA NO CALENDARIO EM COR DESTACADA
 * AO SELECIONAR UM DIA NO CALENDARIO ABRIR UMA CAIXA DE DIALOGO PARA INSERIR UMA NOTA*/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalendarActivity extends AppCompatActivity {
    Button articles, settings;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        articles=(Button)findViewById(R.id.btn_articles);
        settings=(Button)findViewById(R.id.btn_settings);

        articles.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarActivity.this, ArticlesActivity.class));
            }
        }));

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarActivity.this, SettingsActivity.class));
            }
        });
    }
}