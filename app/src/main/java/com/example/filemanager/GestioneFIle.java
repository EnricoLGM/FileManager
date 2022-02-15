package com.example.filemanager;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestioneFIle {
    String nomeFile;
    String TAG="Eccezioni";

    public GestioneFIle() {
        //Costruttore vuoto per non inserire il nome del file
    }

    public GestioneFIle(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public String readFile(String nF, Context c) {
        String risultato="Errore";
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(c.openFileInput(nF)));
            risultato=buffer.readLine();
        }
        catch (FileNotFoundException e) {
            Log.e(TAG,"File Non Trovato");
            e.printStackTrace();
        }
        catch (IOException e) {
            Log.e(TAG,"Errore I/O");
            e.printStackTrace();
        }
        return risultato;
    }
}
