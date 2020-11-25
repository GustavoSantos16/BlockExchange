package br.unip.pimmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MeusInvestimentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_investimentos);
    }

    public void openMenu(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void detalhes(View view) {
        Intent intent = new Intent(this, DetalhesOrdem.class);
        startActivity(intent);
    }
}