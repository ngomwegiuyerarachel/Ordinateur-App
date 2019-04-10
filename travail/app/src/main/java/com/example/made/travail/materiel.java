package com.example.made.travail;

public class materiel  {
    private int id;
    private String name;
    private String prix;
    private byte[] image;

    public materiel(int id, String name, String prix, byte[] image) {
        this.id = id;
        this.name = name;
        this.prix = prix;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
