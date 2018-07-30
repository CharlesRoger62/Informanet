package charlesroger.informanet.DepannagePackage;

/**
 * Created by Charles Roger on 10/07/2018.
 */

public class Depannage {
    private String id;
    private String intervenant;
    private String date;
    private String lieu;
    private String nomClient;
    private String adresseClient;
    private String telephoneClient;
    private String titre;
    private String ordinateur;
    private String description;
    private String prix;
   // private String statut;

    public Depannage(String id, String intervenant, String date, String lieu, String nomClient, String adresseClient, String telephoneClient, String titre, String ordinateur, String description, int prix){
        this.id = id;
        this.intervenant = intervenant;
        this.date = date;
        this.lieu = lieu;
        this.nomClient = nomClient;
        this.adresseClient = adresseClient;
        this.telephoneClient = telephoneClient;
        this.titre = titre;
        this.ordinateur = ordinateur;
        this.description = description;
        this.prix =String.valueOf( prix);
       // this.statut = statut;
    }

    public Depannage(){}

    public  String getId(){return id;}

    public String getIntervenant() {
        return intervenant;
    }

    public String getDate() {
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

    public String getOrdinateur() { return ordinateur; }

    public String getDescription() {
        return description;
    }

    public String getPrix() {
        return prix;
    }

    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    public void setDate(String date) {
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

    public void setTelephoneClient(String telephoneClient) { this.telephoneClient = telephoneClient; }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setOrdinateur(String ordinateur) { this.ordinateur = ordinateur; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
