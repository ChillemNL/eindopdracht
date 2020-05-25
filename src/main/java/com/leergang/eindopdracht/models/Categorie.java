package com.leergang.eindopdracht.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String naamCategorie;
    private String beschrijvingCategorie;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaamCategorie() {
        return this.naamCategorie;
    }
    public String getBeschrijvingCategorie() {
        return this.beschrijvingCategorie;
    }

    public void setNaamCategorie(String naamCategorie) {
        this.naamCategorie = naamCategorie;
    }
    public void setBeschrijvingCategorie(String beschrijvingCategorie) { this.beschrijvingCategorie = beschrijvingCategorie;
    }


}

