package com.lamy.mathilde.projet100h.Class;

import android.widget.EditText;

/**
 * Created by Mathilde on 21/03/2018.
 */

public class User {

    /* attributs de la classe user */
    private String mail ;
    private String password ;
    private boolean admin ;

    /* getter() et setter() de la classe User */
    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public boolean isAdmin() {return admin;}
    public void setAdmin(boolean admin) {this.admin = admin;}

    /*constructeur de la classe User */
    public User(EditText userName, EditText userMail){

    }
    public User(String mail,String password,boolean admin) {
        this.mail=mail;
        this.password=password;
        this.admin=admin;

    }
    public User(){
        // Utile pr Firebase même si non utilisé
    }

}
