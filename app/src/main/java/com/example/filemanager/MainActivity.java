package com.example.filemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView contenutoFile;
    EditText nomeFile;
    Button lettura;
    Button scrittura;

    GestioneFIle gestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenutoFile=(TextView) findViewById(R.id.contenutoFile);
        nomeFile=(EditText) findViewById(R.id.nomeFile);
        lettura=(Button) findViewById(R.id.lettura);
        scrittura=(Button) findViewById(R.id.scrittura);

        gestore = new GestioneFIle();

        lettura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String risultato=gestore.readFile("fileDaLeggere.txt", getApplicationContext());
                contenutoFile.setText(risultato);
            }
        });
        scrittura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nomeFile inserito come prova per l'EditText
                String risultato=gestore.writeFile("fileDaLeggere.txt", getApplicationContext(), nomeFile.getText().toString());
                Toast.makeText(getApplicationContext(), risultato, Toast.LENGTH_LONG).show();
            }
        });
    }
}