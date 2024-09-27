package com.example.cnhnoturno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Enviar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar);

        String relatorio = getIntent().getStringExtra("relatorio");

        ((TextView)findViewById(R.id.Mensagem)).setText(relatorio);
    }
    public void Compartilhar (View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_SUBJECT,
        //        ((TextView)findViewById(R.id.BTcompartilhar)).getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,
                ((TextView)findViewById(R.id.Mensagem)).getText().toString());
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,
                "Compartilhar com ...."));

    }

}