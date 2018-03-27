package com.lamy.mathilde.projet100h.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.lamy.mathilde.projet100h.R;

public class ConnexionActivity extends AppCompatActivity {
    private EditText edtMail;
    private EditText edtPassword;
    private Button btnConnexion;
    private FirebaseAuth auth;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        edtMail = (EditText) findViewById(R.id.editTextMail);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        btnConnexion = (Button) findViewById(R.id.buttonConnexion);
        btnSignUp= (Button) findViewById(R.id.create_account);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConnexionActivity.this, RegisterActivity.class));
            }
        });


        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mail = edtMail.getText().toString();
                final String password = edtPassword.getText().toString();

                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(getApplicationContext(), "Veuillez entrer votre adresse mail", Toast.LENGTH_SHORT).show();
                    return;}

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Veuillez entrer votre mot de passe", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(ConnexionActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            // S'il y a une erreur
                                   /* if (password.length() < 6) {
                                        edtPassword.setError(getString(R.string.minimum_password));
                                    } else { */
                            Toast.makeText(ConnexionActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();

                        } else {
                            Intent intent = new Intent(ConnexionActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }



        });


    }
}
