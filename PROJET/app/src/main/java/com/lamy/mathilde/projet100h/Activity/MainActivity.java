package com.lamy.mathilde.projet100h.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lamy.mathilde.projet100h.R;

public class MainActivity extends AppCompatActivity {

    private Button btnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnEvent = (Button) findViewById(R.id.add_event);

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AjoutEventActivity.class));
            }
        });

    }


}
