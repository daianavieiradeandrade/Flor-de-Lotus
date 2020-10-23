package com.example.flordelotus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    RadioGroup genero;
    RadioButton feminino, masculino;
    EditText regName, regEmail, regPassword, regConfirmPassword;
    Button novoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        novoCadastro = findViewById(R.id.new_cadastro);
        novoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cadastro.this, CalendarAction.class));
            }
        });

        masculino = findViewById(R.id.masculino);
        masculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Masculino";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                startActivity(new Intent(Cadastro.this, InserirConvite.class));
            }
        });

        feminino = findViewById(R.id.feminino);
        feminino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Feminino";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                startActivity(new Intent(Cadastro.this, CadastroPeriodo.class));
            }
        });

    }
}