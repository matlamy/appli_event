package com.lamy.mathilde.projet100h.Class;

/**
 * Created by Mathilde on 21/03/2018.
 */

public class Categorie {

    /* attributs de la classe Categorie */
    private int idCategorie ;
    private String libelleCategorie ;

    /* getter() et setter() de la classe Categorie */
    public int getIdCategorie() {return idCategorie;}
    public void setIdCategorie(int idCategorie) {this.idCategorie = idCategorie;}

    public String getLibelleCategorie() {return libelleCategorie;}
    public void setLibelleCategorie(String libelleCategorie) {this.libelleCategorie = libelleCategorie;}

    /* constructeur de la classe Categorie */
    public Categorie (int idCategorie,String libelleCategorie) {
        this.idCategorie=idCategorie;
        this.libelleCategorie=libelleCategorie;
    }
}
