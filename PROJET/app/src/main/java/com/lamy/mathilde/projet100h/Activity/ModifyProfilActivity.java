package com.lamy.mathilde.projet100h.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.lamy.mathilde.projet100h.R;

public class ModifyProfilActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spinnerPage ;
    private AutoCompleteTextView autoCompleteNom ;
    private AutoCompleteTextView autoCompleteEcole ;
    private String getNom ;
    private String getEcole ;
    private Button boutonSauvegarde ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profil);

        // Saisie du nom d'utilisateur et de l'école + envoie à l'activité profil
            Intent intent = new Intent(this, ProfilActivity.class) ;
            autoCompleteEcole = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewEcole);
            autoCompleteNom = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewNom);


            // récupération des valeurs saisies dans une chaine de caractères
            getNom = autoCompleteNom.getText().toString();
            getEcole = autoCompleteEcole.getText().toString();


            // redirection vers l'activité profil une fois les modificatiosn terminées
        boutonSauvegarde = (Button) findViewById(R.id.buttonSave) ;
        boutonSauvegarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModifyProfilActivity.this, ProfilActivity.class);
                if (!getNom.equals("") && !getNom.equals("")) {
                    // création des bundle pour associer une valeur à une clé
                    Bundle bundle = new Bundle();

                    // association de la clé à la valeur souhaitée
                    bundle.putString("nom", getNom);
                    bundle.putString("ecole", getEcole);

                    intent.putExtras(bundle);
                    intent.putExtras(bundle);

                    // envoie des valeurs saisies à l'activité profil
                    startActivity(intent);

                } else {
                    Toast.makeText(ModifyProfilActivity.this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // menu déroulant permettant de sélectionné la page d'accueil de son choix
        spinnerPage = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.spinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
                spinnerPage.setAdapter(adapter);
            }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        int pageSelected = (int) parent.getItemAtPosition(pos);
        Intent intent = new Intent(ModifyProfilActivity.this,ProfilActivity.class) ;

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}

