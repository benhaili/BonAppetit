package com.example.tpbonapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import entite.Utilisateur;
import manager.UtilisateurManager;
public class RegisterActivity extends AppCompatActivity {
    Button button_register;
    Context ctx;
    EditText nom,email,tel,pass,pass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nom = (EditText) findViewById(R.id.edittext_username);
        pass= (EditText) findViewById(R.id.edittext_password);
        pass1 = (EditText) findViewById(R.id.edittext_password);
        button_register = (Button) findViewById(R.id.button_register);
        ctx=this;


        button_register.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   button_register = findViewById(R.id.btnR);
                                                   nom = findViewById(R.id.edittext_username);
                                                   email = findViewById(R.id.email);
                                                   tel = findViewById(R.id.tel);
                                                   pass = findViewById(R.id.edittext_password);
                                                   pass1 = findViewById(R.id.pass1);
                                               }
        });


        button_register.setOnClickListener(new View.OnClickListener()
            {

                public void onClick (View v){
                if (pass.getText().toString().equals(pass1.getText().toString())) {
                    Utilisateur useUtilisateur = new Utilisateur(nom.getText().toString(), email.getText().toString(), tel.getText().toString(), pass.getText().toString());
                    if (UtilisateurManager.add(ctx, useUtilisateur)) {
                        Toast.makeText(ctx, "User Bien Ajouter", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ctx, "Problem D ajout", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            });
    }
}



