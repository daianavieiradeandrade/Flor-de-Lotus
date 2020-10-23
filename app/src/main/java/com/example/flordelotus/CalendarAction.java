package com.example.flordelotus;

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
        setContentView(R.layout.activity_calendar_action);//definir visualização de conteúdo(R.layout.calendar_action);

        articles = findViewById(R.id.btn_articles);/*articles = encontrar visualização por id (R.id.btn_articles)*/
        settings = findViewById(R.id.btn_settings);/*settings = encontrar visualização por id (R.id.btn_settings)*/

        articles.setOnClickListener((new View.OnClickListener() {//artigos.definir no clique ouvinte, novo visao.nocliqueouvinte
            @Override
            public void onClick(View v) {// metodo publico sem retorno no clique(visualiza v)
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