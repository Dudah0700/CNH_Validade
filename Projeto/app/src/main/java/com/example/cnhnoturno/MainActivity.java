package com.example.cnhnoturno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Nome, Tipo, Idade;

    private TextView relatorio;

    String toxicologyMessage;

    int validade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nome = findViewById(R.id.IDNome);
        Tipo = findViewById(R.id.IDTipo);
        Idade = findViewById(R.id.IDIdade);

        relatorio = findViewById(R.id.IDRelatorio);

        Button GerarRelatorio = findViewById(R.id.BTRelatorio);

        GerarRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(v);
            }
        });
    }
    public void enviar (View view){
        Intent intent = new Intent(getApplicationContext(), Enviar.class);
        intent.putExtra ("relatorio", ((TextView)findViewById(R.id.IDRelatorio)).getText().toString());
        startActivity(intent);
    }
    public void calcular (View view) {

        String nome = (Nome.getText().toString());
        int idade = Integer.parseInt(Idade.getText().toString());
        String tipo = (Tipo.getText().toString());

        switch (tipo.toUpperCase()) {
            case "C":
            case "D":
            case "E":
                toxicologyMessage = " e terá que realizar novo teste toxicológico daqui 2 anos e 6 meses!";
                break;
            default:
                toxicologyMessage = "";
                break;
        }
                if ( idade < 50) {
                    validade = 10;
                } else if ( idade < 70) {
                    validade = 5;
                } else {
                    validade = 3;
            }
        relatorio.setText(String.valueOf(nome+", com "+idade+" anos e carteira tipo "+tipo+" deverá renovar a sua carteira daqui "+validade+ " anos " +toxicologyMessage+"!"));
        }


    }

