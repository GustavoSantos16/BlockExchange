package br.unip.pimmobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void confirmar(View view) {
        Intent intent = new Intent(this, Transacao.class);
        startActivity(intent);
    }

    public void openMenu(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void navegarHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void navegarGrafico(View view) {
        Intent intent = new Intent(this, Grafico.class);
        startActivity(intent);
    }

    public void navegarLivro(View view) {
        Intent intent = new Intent(this, LivroOfertas.class);
        startActivity(intent);
    }
}