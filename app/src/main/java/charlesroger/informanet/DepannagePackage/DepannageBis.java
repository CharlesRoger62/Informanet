package charlesroger.informanet.DepannagePackage;

import java.io.Serializable;

public class DepannageBis implements Serializable {
    public String id;
    public String intervenant;
    public String date;
    public String lieu;
    public String nomClient;
    public String adresseClient;
    public String telephoneClient;
    public String titre;
    public String ordinateur;
    public String description;
    public int prix;

    public DepannageBis(){

    }


    public String getAdresseClient() {
        return adresseClient;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getIntervenant() {
        return intervenant;
    }

    public String getLieu() {
        return lieu;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getOrdinateur() {
        return ordinateur;
    }

    public int getPrix() {
        return prix;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public String getTitre() {
        return titre;
    }


}
