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
    private ToggleButton btnActivGeoloc ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //btnOldEvents = (Button) findViewById(R.id.buttonEventPasse) ;
        btnMenu = (ImageButton) findViewById(R.id.imageButtonMenu);
        btnModif = (ImageButton) findViewById(R.id.imageButtonModify);
        btnActivGeoloc = (ToggleButton) findViewById(R.id.buttonOnOffGeo);
        btnDeconnexion = (Button) findViewById(R.id.buttonDeconnexion);



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
