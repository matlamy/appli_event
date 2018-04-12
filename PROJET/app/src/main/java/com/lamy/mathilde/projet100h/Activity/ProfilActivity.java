package com.lamy.mathilde.projet100h.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.lamy.mathilde.projet100h.R;

public class ProfilActivity extends AppCompatActivity {

    private Button btnDeconnexion ;
    private ImageButton btnModif ;
    private ToggleButton btnActivGeoloc ;
    private TextView textViewEcole ;
    private TextView textViewNom ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //btnOldEvents = (Button) findViewById(R.id.buttonEventPasse) ;
        btnModif = (ImageButton) findViewById(R.id.imageButtonModify);
        btnActivGeoloc = (ToggleButton) findViewById(R.id.buttonOnOffGeo);
        btnDeconnexion = (Button) findViewById(R.id.buttonDeconnexion);
        textViewEcole = (TextView) findViewById(R.id.textViewEcole) ;
        textViewNom = (TextView) findViewById(R.id.textViewNomPrenom) ;


        textViewNom.setText("ok");


        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilActivity.this,ModifyProfilActivity.class) ;

            }
        });


        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(ProfilActivity.this, ConnexionActivity.class);
                startActivity(intent);
            }
        });


    }
}
