package com.example.flordelotus;
/**
 * BOTÃO DE LOGOUT DA CONTA
 * MANTER ATIVA A SESSÃO NO APLICATIVO SEMP PRECISAR FAZER LOGIN TODA VEZ
 * DESCONECTAR PARCEIRO DO APLICATIVO
 * DELETAR A CONTA DO USUARIO
 * BOTAO PARA IR NA TELA DE GERAR CONVITE
 */
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class SettingsActivity extends AppCompatActivity {

    TextView nome, email;
    Button conectarParceiro;
    Button desconectaParceiro;
    Button sair;
    Button deletaConta;
    String userID;
    ProgressBar progressBar;

    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nome = findViewById(R.id.txtFullName);
        email = findViewById(R.id.txtEmail);

        conectarParceiro = findViewById(R.id.btn_conectar_parceiro);
        desconectaParceiro = findViewById(R.id.btn_desconectar_parceiro);
        sair = findViewById(R.id.btn_logout);
        deletaConta = findViewById(R.id.btn_deletar_conta);
        progressBar = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        userID = firebaseAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                nome.setText(documentSnapshot.getString("Nome"));
                email.setText(documentSnapshot.getString("E-mail"));
            }
        });

        conectarParceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, GenerateInvitationActivity.class));
            }
        });
                /*
        deletaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Settings.this);
                dialog.setTitle("Você tem certeza?");
                dialog.setMessage("Deletar a conta vai apagar tudo.");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        progressBar.setVisibility(View.VISIBLE);
                        firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Settings.this, "Conta deletada.", Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(Settings.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(Settings.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
                dialog.setNegativeButton("Desfazer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });
*/
        //TENTAR APLICAR O MODELO DE LOGOUT CERTO
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                Toast.makeText(SettingsActivity.this, "Saindo...", Toast.LENGTH_LONG).show();
            }
        });
    }
}