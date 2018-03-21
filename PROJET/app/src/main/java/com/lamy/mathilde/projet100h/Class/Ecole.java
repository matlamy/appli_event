package com.lamy.mathilde.projet100h.Class;

/**
 * Created by Mathilde on 21/03/2018.
 */

public class Ecole {

    /* attributs de la classe Ecole */
    private int idEcole ;
    private String nomEcole ;
    private String formatMail ;

    /* getter() et setter() de la classe Ecole */
    public int getIdEcole() {return idEcole;}
    public void setIdEcole(int idEcole) {this.idEcole = idEcole;}

    public String getNomEcole() {return nomEcole;}
    public void setNomEcole(String nomEcole) {this.nomEcole = nomEcole;}

    public String getFormatMail() {return formatMail;}
    public void setFormatMail(String formatMail) {this.formatMail = formatMail;}

    /* constructeur de la classe Ecole */
    public Ecole (int idEcole, String nomEcole, String formatMail) {
        this.idEcole = idEcole;
        this.nomEcole = nomEcole;
        this.formatMail = formatMail;
    }
}
