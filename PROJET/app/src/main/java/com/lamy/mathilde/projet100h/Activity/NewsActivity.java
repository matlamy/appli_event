package com.lamy.mathilde.projet100h.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.lamy.mathilde.projet100h.Adapter.ListViewAdapter;
import com.lamy.mathilde.projet100h.Class.Event;
import com.lamy.mathilde.projet100h.R;

public class NewsActivity extends AppCompatActivity {
    private ArrayList<Event> upcomingEventList = new ArrayList<>();
    private ListView upcomingEvents;
    private Adapter upcomingEventsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        upcomingEvents = (ListView) findViewById(R.id.upcoming_events);
        // On crée l'adapter par rapport aux données présentes dans la liste
        upcomingEventsAdapter = new ListViewAdapter(this, upcomingEventList);
        // On attache l'adapter
        upcomingEvents.setAdapter((ListAdapter) upcomingEventsAdapter);
        // On crée enfin la méthode qui va détecter le clic sur un item en particulier
        upcomingEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent eventPreview = new Intent(NewsActivity.this, DetailsEventActivity.class);
                eventPreview.putExtra("idEvent", upcomingEventList.get(i).getIdEvent());
                eventPreview.putExtra("eventName", upcomingEventList.get(i).getNameEvent());
                eventPreview.putExtra("dateStart", upcomingEventList.get(i).getDateStart());
                eventPreview.putExtra("dateEnd", upcomingEventList.get(i).getDateEnd());
                eventPreview.putExtra("latitude", upcomingEventList.get(i).getLatitude());
                eventPreview.putExtra("longitude", upcomingEventList.get(i).getLongitude());
                eventPreview.putExtra("prix", upcomingEventList.get(i).getPrix());
                eventPreview.putExtra("nbParticip", upcomingEventList.get(i).getNbParticip());
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

                    upcomingEventList.add(event); // On ajoute l'événement dans la liste des événements à venir...
                  //  upcomingEventsAdapter.notifyDataSetChanged(); // ... puis on notifie à l'adaptateur les changements
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
