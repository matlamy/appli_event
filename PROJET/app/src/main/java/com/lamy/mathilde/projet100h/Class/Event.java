package com.lamy.mathilde.projet100h.Class;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mathilde on 21/03/2018.
 */

@IgnoreExtraProperties
public class Event implements Serializable {


    /* attributs de la classe Event */
    private int idEvent ;
    private long dateStart ;
    private Timestamp dateEnd ;
    private int prix ;
    private int nbParticip ;
    private String nameEvent ;
    private double latitude ;
    private double longitude ;
    private boolean visible ;
    private boolean prive ;
    private String createur ;


    /* getter() et setter() de chaque attribut de la classe Event */
    public long getDateStart() {return dateStart;}
    public void setDateStart(long dateStart) {this.dateStart = dateStart;}

    public Timestamp getDateEnd() {return dateEnd;}
    public void setDateEnd(Timestamp dateEnd) {this.dateEnd = dateEnd;}

    public int getIdEvent() {return idEvent;}
    public void setIdEvent(int idEvent) {this.idEvent = idEvent;}

    public int getPrix() {return prix;}
    public void setPrix(int prix) {this.prix = prix;}

    public int getNbParticip() {return nbParticip;}
    public void setNbParticip(int nbParticip) {this.nbParticip = nbParticip;}

    public String getNameEvent() {return nameEvent;}
    public void setNameEvent(String nameEvent) {this.nameEvent = nameEvent;}

    public double getLatitude() {return latitude;}
    public void setLatitude(double latitude) {this.latitude = latitude;}

    public double getLongitude() {return longitude;}
    public void setLongitude(double longitude) {this.longitude = longitude;}

    public boolean isPrive() {return prive;}
    public void setPrive(boolean prive) {this.prive = prive;}

    public boolean isVisible() {return visible;}

    public void setVisible(boolean visible) {this.visible = visible;}

    public String getCreateur() {return createur;}
    public void setCreateur(String createur) {this.createur = createur;}

    /* constructeur de la classe Event */
    public Event(int idEvent,long dateStart,Timestamp dateEnd,int prix,int nbParticip,String nameEvent,double latitude,double longitude,boolean prive,boolean visible,String createur) {
        this.idEvent=idEvent;
        this.dateEnd=dateEnd;
        this.dateStart=dateStart;
        this.prix=prix;
        this.nbParticip=nbParticip;
        this.nameEvent=nameEvent;
        this.latitude=latitude;
        this.longitude=longitude;
        this.prive=prive;
        this.visible=visible;
        this.createur=createur;
    }

    public Event() {}

    @Override
    public String toString() {
        return "Event{" +
                "name='" + nameEvent + '\'' +
                ", id='" + idEvent + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", createur=" + createur +
                ", prix=" + prix +
                ", nbparticipant=" + nbParticip +
                '}';
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", nameEvent);
        result.put("id", idEvent);
        result.put("dateStart", dateStart);
        result.put("dateEnd", dateEnd);
        result.put("latitude", latitude);
        result.put("longitude", longitude);
        result.put("createur", createur);
        result.put("prix", prix);
        result.put("nbparticipant", nbParticip);


        return result;


    }
}
