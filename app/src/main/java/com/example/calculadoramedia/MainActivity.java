package com.example.calculadoramedia;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private EditText notaAva1;
    private EditText notaAva2;
    private EditText notaAva3;
    private EditText editTextResultado;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        notaAva1 = findViewById(R.id.notaAva1);
        notaAva2 = findViewById(R.id.notaAva2);
        notaAva3 = findViewById(R.id.notaAva3);
        editTextResultado = findViewById(R.id.editTextResultado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }



    public void onClickButtonCalcular(View v) {
        if (!notaAva1.getText().toString().equals("")) {
            if (!notaAva2.getText().toString().equals("")) {
                if (!notaAva3.getText().toString().equals("")) {
                    double soma = Double.parseDouble(notaAva1.getText().toString()) + Double.parseDouble(notaAva2.getText().toString()) + Double.parseDouble(notaAva3.getText().toString());
                    double media = soma / 3;
                    editTextResultado.setText("" + media);
                } else {
                    Toast.makeText(MainActivity.this, "Digite terceira nota", Toast.LENGTH_SHORT).show();
                    notaAva3.requestFocus();
                }
            } else {
                Toast.makeText(MainActivity.this, "Digite a segunda nota", Toast.LENGTH_SHORT).show();
                notaAva2.requestFocus();
            }
        } else {
            Toast.makeText(MainActivity.this, "Digite a primeira nota", Toast.LENGTH_SHORT).show();
            notaAva1.requestFocus();
        }
    }

    public void onClickButtonLimpar(View v) {
        notaAva1.setText("");
        notaAva2.setText("");
        notaAva3.setText("");
        editTextResultado.setText("");
    }

    public void onClickBotaoFechar(View v) {
        System.exit(0);

    }

}