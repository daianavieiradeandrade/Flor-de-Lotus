package com.example.flordelotus;
/**
 * SE CÓDIGO DIGITADO PELO PARCEIRO ESTIVER RELACIONADO A ALGUM CAMPO DE QUALQUER USUARIO NO FIREBASE...
 * ...COLOCAR COMO UM MODELO DE SOLICITAÇÃO DE PARCEIRO ACEITA
 * VER SE É POSSIVEL VER INFORMAÇÃO EM MODO LEITURA DOS DADOS DA USUARIA FEMININA
 * */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputInvitationActivity extends AppCompatActivity {

    Button validar;
    EditText convite;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_invitation);

        validar = findViewById(R.id.btn_verifica_convite);
        convite = findViewById(R.id.etd_meu_convite);

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Validando código...";
                int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
        });
    }
}