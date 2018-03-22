package com.lamy.mathilde.projet100h.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.lamy.mathilde.projet100h.R;

public class ProfilActivity extends AppCompatActivity {

    private Button btnDeconnexion ;
    private ImageButton btnModif ;
    private ImageButton btnMenu ;
    private Button btnOldEvents ;
    private ToggleButton btnActivGeoloc ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btnOldEvents = (Button) findViewById(R.id.buttonEventPasse) ;
        btnMenu = (ImageButton) findViewById(R.id.imageButtonMenu);
        btnModif = (ImageButton) findViewById(R.id.imageButtonModify);
        btnActivGeoloc = (ToggleButton) findViewById(R.id.buttonOnOffGeo);
        btnDeconnexion = (Button) findViewById(R.id.buttonDeconnexion);



       /* spinnerPages = (Spinner) findViewById(R.id.spinnerPageAccueil);
        List pagesList = new ArrayList();
        pagesList.add("Plan");
        pagesList.add("Calendrier");
        pagesList.add("News");
		Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (exemple)
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pagesList);
         On definit une présentation du spinner quand il est déroulé (android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spinnerPages.setAdapter(adapter);
        */

        btnOldEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilActivity.this, OldEventsActivity.class);
                startActivity(intent);
            }
        });

        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut()
                Intent intent = new Intent(ProfilActivity.this, ConnexionActivity.class);
                startActivity(intent);
            }
        });


    }
}
