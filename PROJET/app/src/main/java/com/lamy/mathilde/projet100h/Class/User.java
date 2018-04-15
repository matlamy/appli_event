package com.lamy.mathilde.projet100h.Class;

import android.widget.EditText;

/**
 * Created by Mathilde on 21/03/2018.
 */

public class User {

    /* attributs de la classe user */
    private String UserName;
    private String mail ;
    private String password ;
    private boolean admin ;

    /* getter() et setter() de la classe User */
    public String getUserName() {return UserName;}
    public void setUserName(String UserName) {this.UserName = UserName;}

    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public boolean isAdmin() {return admin;}
    public void setAdmin(boolean admin) {this.admin = admin;}

    /*constructeur de la classe User */
    public User(EditText userName, EditText userMail){

    }
    public User(String UserName, String mail,String password,boolean admin) {
        this.UserName=UserName;
        this.mail=mail;
        this.password=password;
        this.admin=admin;

    }
    public User(){
        // Utile pr Firebase même si non utilisé
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + UserName + '\'' +
                ", mail='" + mail + '\'' +
                ", password=" + password +
                ", Admin=" + admin +
                '}';

}
}
