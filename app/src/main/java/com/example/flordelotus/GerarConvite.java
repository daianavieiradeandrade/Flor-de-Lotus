package com.example.flordelotus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GerarConvite extends AppCompatActivity {

    private TextView txtCodigo;
    private Button btnGerar;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_convite);

        txtCodigo = findViewById(R.id.txt_codigo);
        btnGerar = findViewById(R.id.btn_gerar);
        btnShare = findViewById(R.id.btn_share);

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText(getRandomString(10));
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String share = txtCodigo.toString();
                intent.putExtra(Intent.EXTRA_TEXT, share);
                startActivity(Intent.createChooser(intent, "Enviar código usando"));
            }
        });

    }
    /*METODO DE GERAR TEXTO RANDOMICO*/
    public static String getRandomString(int i) {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        while(i>0){
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            i--;
        }
        return result.toString();
    }

}