package com.example.chefsjournal.ui.login;

public class Recette {
    private String nom;
    private String chef;
    private int imageResId;

    public Recette(String nom, String chef, int imageResId) {
        this.nom = nom;
        this.chef = chef;
        this.imageResId = imageResId;
    }

    public String getNom() {
        return nom;
    }

    public String getChef() {
        return chef;
    }

    public int getImageResId() {
        return imageResId;
    }
}

