package com.example.made.travail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class formulaireprincipale extends AppCompatActivity {

    DatabaseHelper mydb;
    LinearLayout editlayout,editclient,editpropietaire,editventes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaireprincipale);

        editlayout=(LinearLayout) findViewById(R.id.passager);
        editclient=(LinearLayout) findViewById(R.id.txtclient);
        editpropietaire=(LinearLayout) findViewById(R.id.txtmat);
        editventes=(LinearLayout) findViewById(R.id.txtform);


        editlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(formulaireprincipale.this,LoadClientActivity.class);
                startActivity(intent1);
            }
        });


        editclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(formulaireprincipale.this,ventes.class);
                startActivity(intent1);
            }
        });

        editpropietaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(formulaireprincipale.this,activity_client.class);
                startActivity(intent1);
            }
        });

        editventes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(formulaireprincipale.this,activity_materiel.class);
                startActivity(intent1);
            }
        });

    }
}
