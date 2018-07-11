package charlesroger.informanet;

import java.sql.Date;

/**
 * Created by charles on 10/07/2018.
 */

public class Depannage {
    private String intervenant;
    private Date date;
    private String lieu;
    private String nomClient;
    private String adresseClient;
    private String telephoneClient;
    private String titre;
    private String description;
    private int prix;

    public Depannage(String intervenant,Date date, String lieu, String nomClient, String adresseClient, String telephoneClient, String titre, String description, int prix){
        this.intervenant = intervenant;
        this.date = date;
        this.lieu = lieu;
        this.nomClient = nomClient;
        this.adresseClient = adresseClient;
        this.telephoneClient = telephoneClient;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
    }

    public String getIntervenant() {
        return intervenant;
    }
    public Date getDate() {
        return date;
    }
    public String getLieu() {
        return lieu;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getPrix() {
        return prix;
    }

    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}