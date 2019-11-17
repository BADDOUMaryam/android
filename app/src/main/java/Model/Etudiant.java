package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Etudiant implements Serializable {
    private String nom;
    private String prenom;
    private String cne;
    private Boolean isPresent=false;
    static ArrayList<Etudiant> etudiants=new ArrayList<>();

    public static ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public static void setEtudiants(ArrayList<Etudiant> etudiants) {
        Etudiant.etudiants = etudiants;
    }

    public Etudiant(String nom, String prenom, String cne) {
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    @Override
    public String toString() {
        return " "+cne+"  "+nom+"  "+prenom;
    }
}
