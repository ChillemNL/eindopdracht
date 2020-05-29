package com.leergang.eindopdracht;

public class ActiviteitRequest {
    private Integer categorieId;
    private String naamOrganisatie;
    private String plaats;
    private String regio;
    private String naamActiviteit;
    private String beschrijvingActiviteit;
    private int kosten;
    private String leeftijdscategorie;
    private String soortActiviteit;
    private String website;

    public Integer getCategorieId(){return categorieId;}

    public String getNaamOrganisatie() {
        return naamOrganisatie;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getRegio() {
        return regio;
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

    public void setCategorieId(Integer categorieId){this.categorieId = categorieId;}

    public void setNaamOrganisatie(String naamOrganisatie) {
        this.naamOrganisatie = naamOrganisatie;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setRegio(String regio) {
        this.regio = regio;
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
