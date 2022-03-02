package com.example.filemanager;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GestioneFile {
    String nomeFile;
    String TAG="Eccezioni";

    public GestioneFile() {
        //Costruttore vuoto per non inserire il nome del file
    }

    public GestioneFile(String nomeFile) {
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

    //stream orientato ai byte
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

    //che utilizza il buffered writer che legge una riga di caratteri
    public String writeFileBuffered(String nF, Context c, String cont) {
        FileOutputStream fileOut;
        String risultato;
        BufferedWriter writer;
        try {
            writer=new BufferedWriter(new OutputStreamWriter(c.openFileOutput(nF, Context.MODE_PRIVATE)));
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

    public String leggiRawFile(Context c) {
        String testo;
        StringBuilder sb=new StringBuilder();
        Resources res=c.getResources();
        InputStream is=res.openRawResource(R.raw.brani);
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        try {
            while((testo=br.readLine())!=null) {
                sb.append(testo + "\n");
            }
        } catch (IOException e) {
            Log.e(TAG, "I/O Exception");
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String leggiAssetsFile(Context c) {
        String testo;
        StringBuilder sb=new StringBuilder();
        AssetManager asset=c.getAssets();
        //InputStream is=asset.open("prova");
        //BufferedReader br=new BufferedReader(new InputStreamReader(is));
        try {
            InputStream is=asset.open("prova.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            while((testo=br.readLine())!=null) {
                sb.append(testo + "\n");
            }
        } catch (IOException e) {
            Log.e(TAG, "I/O Exception");
            e.printStackTrace();
        }
        return sb.toString();
    }
}
