package com.leergang.eindopdracht.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activiteit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String naamOrganisatie;
    private String adres;
    private String postcode;
    private String plaats;
    private String telefoonnummer;
    private String naamActiviteit;
    private String beschrijvingActiviteit;
    private int kosten;
    private String leeftijdscategorie;
    private String soortActiviteit;
    private String website;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaamOrganisatie() {
        return naamOrganisatie;
    }

    public String getAdres() {
        return adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

       public String getNaamActiviteit() {
        return naamActiviteit;
    }

    public String getBeschrijvingActiviteit() {
        return beschrijvingActiviteit;
    }

    public int getKosten() {
        return kosten;
    }

    public String getLeeftijdscategorie() {
        return leeftijdscategorie;
    }

    public String getSoortActiviteit() {
        return soortActiviteit;
    }

    public String getWebsite() {
        return website;
    }

    public void setNaamOrganisatie(String naamOrganisatie) {
        this.naamOrganisatie = naamOrganisatie;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public void setNaamActiviteit(String naamActiviteit) {
        this.naamActiviteit = naamActiviteit;
    }

    public void setBeschrijvingActiviteit(String beschrijvingActiviteit) {
        this.beschrijvingActiviteit = beschrijvingActiviteit;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

    public void setLeeftijdscategorie(String leeftijdscategorie) {
        this.leeftijdscategorie = leeftijdscategorie;
    }

    public void setSoortActiviteit(String soortActiviteit) {
        this.soortActiviteit = soortActiviteit;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

