package br.unip.pimmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void navegarPerfil(View view) {
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    public void navegarTermos(View view) {
        Intent intent = new Intent(this, Termos.class);
        startActivity(intent);
    }

    public void navegarMeusInvestimentos(View view) {
        Intent intent = new Intent(this, MeusInvestimentos.class);
        startActivity(intent);
    }

    public void navegarTransferencia(View view) {
        Intent intent = new Intent(this, Transferencia.class);
        startActivity(intent);
    }

    public void navegarHome(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void sair(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }





}