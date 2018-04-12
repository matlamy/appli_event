package com.lamy.mathilde.projet100h.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.lamy.mathilde.projet100h.R;

public class ModifyProfilActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText edtNom ;
    private EditText edtEcole ;
    private Spinner spinnerPage ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profil);

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

