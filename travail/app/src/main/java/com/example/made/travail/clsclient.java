package com.example.made.travail;

public class clsclient {
    //IDmat INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRIX TEXT,IMAGE Byte not null

    public  clsclient(int idmat,String namematriel,String prixmateriel,byte[] imagemateriel){
        this.setIdmat(idmat);
        this.setNamematriel(namematriel);
        this.setPrixmateriel(prixmateriel);
        this.setImagemateriel(imagemateriel);
    }
    public int getIdmat() {
        return idmat;
    }

    public void setIdmat(int idmat) {
        this.idmat = idmat;
    }

    public String getNamematriel() {
        return namematriel;
    }

    public void setNamematriel(String namematriel) {
        this.namematriel = namematriel;
    }

    public String getPrixmateriel() {
        return prixmateriel;
    }

    public void setPrixmateriel(String prixmateriel) {
        this.prixmateriel = prixmateriel;
    }

    public byte[] getImagemateriel() {
        return imagemateriel;
    }

    public void setImagemateriel(byte[] imagemateriel) {
        this.imagemateriel = imagemateriel;
    }

    int idmat;
    String namematriel;
    String prixmateriel;
    byte[] imagemateriel;

}
