package com.example.filemanager;

public class Brano {
    String titolo;
    String autore;
    String durata;
    String dataUscita;
    String genere;

    public Brano(String titolo, String autore, String durata, String dataUscita, String genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.durata = durata;
        this.dataUscita = dataUscita;
        this.genere = genere;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public void setDataUscita(String dataUscita) {
        this.dataUscita = dataUscita;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getDurata() {
        return durata;
    }

    public String getDataUscita() {
        return dataUscita;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return titolo+", "+autore+", "+durata+", "+dataUscita+", "+genere;
    }
}
