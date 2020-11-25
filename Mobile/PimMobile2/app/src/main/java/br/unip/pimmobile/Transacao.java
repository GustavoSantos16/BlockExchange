package br.unip.pimmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Transacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacao);
    }

    public void openMenu(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void confirmar(View view) {
        Intent intent = new Intent(this, MeusInvestimentos.class);
        startActivity(intent);
    }
}