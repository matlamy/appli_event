package com.lamy.mathilde.projet100h.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;


import com.lamy.mathilde.projet100h.R;

public class MenuActivity extends AppCompatActivity {
    private Button btnPlan;
    private Button btnCalendrier;
    private Button btnNews;
    private Button btnProfil;
    private String[] drawerItemsList;
    private ListView myDrawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nom = extras.getString("cleNom");
            Toast.makeText(this,nom, Toast.LENGTH_SHORT).show();
        }

        btnPlan = (Button) findViewById(R.id.buttonPlan)  ;
        btnCalendrier = (Button) findViewById(R.id.buttonCalendrier) ;
        btnNews = (Button) findViewById(R.id.buttonNews);
        btnProfil = (Button) findViewById(R.id.buttonProfil) ;

        btnPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        btnCalendrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,CalendrierActivity.class);
                startActivity(intent);
            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });

        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,ProfilActivity.class);
                startActivity(intent);
            }
        });




    }
}
