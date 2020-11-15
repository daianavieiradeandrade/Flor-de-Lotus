package com.example.flordelotus;
/**
* 1. metodo que ao selecionar o dia deve para abrir uma caixa de dialogo aonde se pode inserir um texto relacionado a esse dia
* 2. pegar o dado de cadastro de periodo e salvar em uma collection no firebase
* 3. a ultima menstruacao cadastrada devera estar com uma cor destacada no calendarview
* 4. as notas deverao ser exibidas na caixa superior acho que deve ser usado recyclerview
* 5. adicionar ponto de notificação sobre notas adicionadas, posts adicionados, e previsao de dias da proxima menstruacao
* */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalendarAction extends AppCompatActivity {
    Button articles, settings;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_action);

        articles=(Button)findViewById(R.id.btn_articles);
        settings=(Button)findViewById(R.id.btn_settings);

        articles.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarAction.this, ArticlesUser.class));
            }
        }));

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarAction.this, Settings.class));
            }
        });
    }
}