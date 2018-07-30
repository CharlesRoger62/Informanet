package charlesroger.informanet;

/**
 * Created by Charles Roger on 16/07/2018.
 */

public class Utilisateur {
    private String nom;
    private String societe;
    private String telephone;
    private String email;

    public Utilisateur( String nom, String societe, String telephone, String email){
        this.nom = nom;
        this.societe = societe;
        this.telephone = telephone;
        this.email = email;
    }

    public Utilisateur(){
    }

    public String getNom() {
        return nom;
    }
    public String getEmail() {
        return email;
    }
    public String getSociete() {
        return societe;
    }
    public String getTelephone() {
        return telephone;
    }
    //public byte[] getAvatar() {return avatar;}

    public void setNom(String nom) {this.nom = nom;}
    public void setSociete(String societe) {
        this.societe = societe;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //public void setAvatar(byte[] avatar) {this.avatar = avatar;}
}
