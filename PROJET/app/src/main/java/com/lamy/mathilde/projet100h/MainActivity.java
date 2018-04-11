package com.lamy.mathilde.projet100h;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.lamy.mathilde.projet100h.Activity.AjoutEventActivity;
import com.lamy.mathilde.projet100h.Activity.ConnexionActivity;
import com.lamy.mathilde.projet100h.Activity.DetailsEventActivity;
import com.lamy.mathilde.projet100h.Activity.RegisterActivity;
import com.lamy.mathilde.projet100h.Adapter.ListViewAdapter;
import com.lamy.mathilde.projet100h.Class.Event;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnEvent;
    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;
    protected ListView upcomingEvents, pastEvents;
    protected ListViewAdapter upcomingEventsAdapter, pastEventsAdapter;
    protected ArrayList<Event> upcomingEventList = new ArrayList<>();
    protected ArrayList<Event> pastEventList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeButtons();
        initializeListView();


        btnEvent = (Button) findViewById(R.id.add_event);

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AjoutEventActivity.class));
            }
        });

    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    /**
     * Méthode d'initialisation des boutons
     */
    private void initializeButtons(){
        btnEvent = (Button)findViewById(R.id.add_event);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AjoutEventActivity.class));
            }
        });
    }

    /**
     * Méthode d'initialisation de la ListView
     */
    private void initializeListView(){
        upcomingEvents = (ListView) findViewById(R.id.upcoming_events);
        pastEvents = (ListView) findViewById(R.id.past_events);

        // On crée l'adapter par rapport aux données présentes dans la liste
        upcomingEventsAdapter = new ListViewAdapter(this, upcomingEventList);
        // On attache l'adapter
        upcomingEvents.setAdapter(upcomingEventsAdapter);
        // On crée enfin la méthode qui va détecter le clic sur un item en particulier
        upcomingEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent eventPreview = new Intent(MainActivity.this, DetailsEventActivity.class);
                eventPreview.putExtra("eventName", upcomingEventList.get(i).getNameEvent());
                eventPreview.putExtra("date", upcomingEventList.get(i).getDateStart());
               /* eventPreview.putExtra("username", upcomingEventList.get(i).getUser());*/
                eventPreview.putExtra("latitude", upcomingEventList.get(i).getLatitude());
                eventPreview.putExtra("longitude", upcomingEventList.get(i).getLongitude());
                startActivity(eventPreview);
            }
        });

        // On crée l'adapter par rapport aux données présentes dans la liste
        pastEventsAdapter = new ListViewAdapter(this, pastEventList);
        // On attache l'adapter
        pastEvents.setAdapter(pastEventsAdapter);
        // On crée enfin la méthode qui va détecter le clic sur un item en particulier
        pastEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent eventPreview = new Intent(MainActivity.this, DetailsEventActivity.class);
                eventPreview.putExtra("eventName", pastEventList.get(i).getNameEvent());
                eventPreview.putExtra("date", pastEventList.get(i).getDateStart());
                /*eventPreview.putExtra("username", pastEventList.get(i).getUser());*/
                eventPreview.putExtra("latitude", pastEventList.get(i).getLatitude());
                eventPreview.putExtra("longitude", pastEventList.get(i).getLongitude());
                startActivity(eventPreview);
            }
        });

        prepareEventsDatas();

    }

    /**
     * Méthode qui va récupérer les données des événements enregistrés sur la base de données Firebase
     */
    private void prepareEventsDatas(){

        FirebaseDatabase.getInstance().getReference().child("events").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // Etape 1 : On récupère les données sous forme d'objet Event
                Event event = dataSnapshot.getValue(Event.class);

                // Etape 2 : Ici, pour faire la distinction entre les événements passés et ceux à venir,
                //              on teste la valeur Timestamp de l'événement par rapport à la valeur
                //              Timestamp actuelle du système.
                if(event.getDateStart() * 1000L < System.currentTimeMillis()){ // Si le Timestamp de l'événement est inférieur à la valeur actuelle du Timestamp système
                    pastEventList.add(event); // On ajoute l'événement dans la liste des événements passés...
                    pastEventsAdapter.notifyDataSetChanged(); // ... puis on notifie à l'adaptateur les changements
                } else { // Sinon, cela veut dire que l'événement n'est pas encore passé !
                    upcomingEventList.add(event); // On ajoute l'événement dans la liste des événements à venir...
                    upcomingEventsAdapter.notifyDataSetChanged(); // ... puis on notifie à l'adaptateur les changements
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });


}


}
