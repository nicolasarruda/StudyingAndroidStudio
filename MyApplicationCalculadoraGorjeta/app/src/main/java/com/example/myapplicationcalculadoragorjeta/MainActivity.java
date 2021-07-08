package com.example.myapplicationcalculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private com.google.android.material.textfield.TextInputLayout preco;
    private SeekBar progressoGorjeta;
    private double calcporcentagem = 0;
    private TextView porcento;
    private TextView gorjeta;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preco = findViewById(R.id.preco);
        progressoGorjeta = findViewById(R.id.progressoGorjeta);
        porcento = findViewById(R.id.porcento);
        gorjeta = findViewById(R.id.gorjeta);
        total = findViewById(R.id.total);

        progressoGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcento.setText(progress + "%");
                calcporcentagem = (double) progress;
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        String valor = preco.getEditText().getText().toString();
        if (valor == null || valor.equals("")){
            Toast.makeText(this , "Precisa primeiro colocar valor", Toast.LENGTH_SHORT).show();
        }

        double valorDigitado = Double.parseDouble(valor);
        double valorGorjeta = valorDigitado * (calcporcentagem/ 100);
        double valorTotal = valorDigitado + valorGorjeta;
        gorjeta.setText("R$ " + (valorGorjeta));
        total.setText("R$ " + (valorTotal));
    }


}
