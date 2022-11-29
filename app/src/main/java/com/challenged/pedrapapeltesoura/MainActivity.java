package com.challenged.pedrapapeltesoura;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.escolhaUsuario("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.escolhaUsuario("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.escolhaUsuario("Tesoura");
    }

    @SuppressLint("SetTextI18n")
    public void escolhaUsuario(String escolhaUsuario) {

        ImageView imgAlternation = findViewById(R.id.imgAlternation);
        TextView textoResultado = findViewById(R.id.textResultado);

        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numero = new Random().nextInt(3);

        String escolhaApp = opcoes[numero];
        switch (escolhaApp) {
            case "pedra":
                imgAlternation.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgAlternation.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgAlternation.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp=="pedra" && escolhaUsuario=="tesoura") ||
                (escolhaApp=="papel" && escolhaUsuario=="pedra") ||
                (escolhaApp=="tesoura" && escolhaUsuario=="papel")
        ){
            textoResultado.setText("Você perdeu :( ");
        }else if (
                (escolhaUsuario=="pedra" && escolhaApp=="tesoura") ||
                (escolhaUsuario=="papel" && escolhaApp=="pedra") ||
                (escolhaUsuario=="tesoura" && escolhaApp=="papel")
        ){
            textoResultado.setText("Você ganhou :) ");

        }else {
            textoResultado.setText("Empatamos ;) ");
        }
    }
}