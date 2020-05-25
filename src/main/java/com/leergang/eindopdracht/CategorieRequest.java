package com.leergang.eindopdracht;

public class CategorieRequest {
    private String naamCategorie;
    private String beschrijvingCategorie;

    public String getNaamCategorie() {
        return naamCategorie;
    }

    public String getBeschrijvingCategorie() {
        return beschrijvingCategorie;
    }

    public void setNaamCategorie(String naamCategorie) {
        this.naamCategorie = naamCategorie;
    }

    public void setBeschrijvingCategorie(String beschrijvingCategorie) {
        this.beschrijvingCategorie = beschrijvingCategorie;
    }
}