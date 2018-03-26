package com.lamy.mathilde.projet100h.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import com.google.firebase.database.DatabaseReference;
import com.lamy.mathilde.projet100h.Class.User;
import com.lamy.mathilde.projet100h.R;

public class RegisterActivity extends AppCompatActivity {

    protected EditText userName, userMail, userPassword;
    protected Button register;
    private FirebaseAuth auth;
    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeButtons();
        initializeEditText();
    }

    /**
     * Méthode d'initialisation des EditText
     */
    private void initializeEditText() {
        userName = (EditText) findViewById(R.id.username);
        userMail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);
    }

    /**
     * Méthode d'initialisation des boutons
     *
     * @see FirebaseAuth
     */
    private void initializeButtons() {
        register = (Button) findViewById(R.id.button_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Enregistrement de l'utilisateur via FirebaseAuth
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(userMail.getText().toString(), userPassword.getText().toString())
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // On crée également une requête pour mettre à jour le nom de l'utilisateur (qui par défaut a la valeur null)
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(userName.getText().toString())
                                            .build();

                                    // Puis on met à jour ses données. Si les données sont bien mises à jour, on redirigera l'utilisateur vers
                                    // l'accueil de l'application.
                                    task.getResult().getUser().updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        startActivity(new Intent(RegisterActivity.this, MenuActivity.class));
                                                    }
                                                }
                                            });


                                }
                            }
                        });
            }
        });
    }
    private void createNewUser(FirebaseUser userFromRegistration) {
        String username = userName.getText().toString().trim();
        String email = userFromRegistration.getEmail();
        String userId = userFromRegistration.getUid();

        User user = new User(userName, userMail);

        mdatabase.child("users").child(userId).setValue(user);
    }
}
