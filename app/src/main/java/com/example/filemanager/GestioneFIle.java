package com.example.filemanager;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        String risultato="";
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(c.openFileInput(nF)));
            while((risultato=buffer.readLine())!=null) {
                sb.append(risultato+"\n");
            }
        }
        catch (FileNotFoundException e) {
            Log.e(TAG,"File Non Trovato");
            e.printStackTrace();
        }
        catch (IOException e) {
            Log.e(TAG,"Errore I/O");
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String writeFile(String nF, Context c, String cont) {
        FileOutputStream fileOut;
        String risultato;
        try {
            fileOut=c.openFileOutput(nF, Context.MODE_PRIVATE);
            fileOut.write(cont.getBytes());
            fileOut.close();
            risultato="File Scritto Correttamente";
        }
        catch (FileNotFoundException e) {
            risultato="Errore";
            Log.e(TAG,"File Non Trovato");
            e.printStackTrace();
        }
        catch (IOException e) {
            risultato="Errore";
            Log.e(TAG,"Errore I/O");
            e.printStackTrace();
        }
        return risultato;
    }
}
