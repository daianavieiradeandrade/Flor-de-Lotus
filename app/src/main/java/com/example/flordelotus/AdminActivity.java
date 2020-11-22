package com.example.flordelotus;
/**
 * INSERIR POSTAGENS E JOGAR ELAS PARA OS USUARIOS GERAIS
 * VER A POSTAGEM CRIADA EDITAR OU DELETAR
 * ADICIONAR A HORA E DATA DA POSTAGEM
 **/
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AdminActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference artigoReferencia = db.collection("Artigos");

    private ArticlesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        FloatingActionButton botaoAddPost = findViewById(R.id.botao_add_post);
        botaoAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, NewPostActivity.class));
            }
        });

        configurarRecyclerView();
    }

    private void configurarRecyclerView() {
        Query query = artigoReferencia.orderBy("prioridade", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Articles> opcoes = new FirestoreRecyclerOptions.Builder<Articles>()
                .setQuery(query, Articles.class)
                .build();

        adapter = new ArticlesAdapter(opcoes);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}