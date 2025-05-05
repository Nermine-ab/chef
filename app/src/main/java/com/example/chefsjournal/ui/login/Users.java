package com.example.chefsjournal.ui.login;

public class Users {
    private String id ;
    private String nom ;
    private String prenom ;
    private String username ;
    private String adr ;
    private String mdp ;

    public Users(String nom, String prenom, String username, String adr, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.adr = adr;
        this.mdp = mdp;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
