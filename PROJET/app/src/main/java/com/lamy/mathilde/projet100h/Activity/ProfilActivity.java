package com.lamy.mathilde.projet100h.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.lamy.mathilde.projet100h.R;

public class ProfilActivity extends AppCompatActivity {

    private Button btnDeconnexion ;
    private ImageButton btnModif ;
    private TextView textViewEcole ;
    private TextView textViewNom ;
    private int i = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btnModif = (ImageButton) findViewById(R.id.imageButtonModify);
        btnDeconnexion = (Button) findViewById(R.id.buttonDeconnexion);
        textViewEcole = (TextView) findViewById(R.id.textViewEcole) ;
        textViewNom = (TextView) findViewById(R.id.textViewNomPrenom) ;


        if (i!=0) {
            // Mise à jour du nom et l'école de l'utilisateur
            Bundle bundle = getIntent().getExtras();
            String nom = bundle.getString("nom");
            String ecole = bundle.getString("ecole");

            textViewEcole.setText(ecole);
            textViewNom.setText(nom);

        }



        // redirection vers l'activity modify profil
        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmodif = new Intent(ProfilActivity.this,ModifyProfilActivity.class) ;
                i ++ ;
            }
        });

        // deconnexion de l'application
        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intentdeconnexion = new Intent(ProfilActivity.this, ConnexionActivity.class);
                startActivity(intentdeconnexion);
            }
        });


    }
}
