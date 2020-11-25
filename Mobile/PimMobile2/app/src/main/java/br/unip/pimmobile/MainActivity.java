package br.unip.pimmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void cadastrar(View view) {
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }
}