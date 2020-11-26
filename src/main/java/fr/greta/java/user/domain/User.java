package fr.greta.java.user.domain;

import fr.greta.java.generic.tools.StringTool;

public class User {

    private int id;
    private String nom;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //----------------------------------------------------------------
    public boolean nomIsValid() {
        return !StringTool.isNullOrEmpty(getNom());
    }
    public boolean emailIsValid() {
        return !StringTool.isNullOrEmpty(getEmail());
    }
}
