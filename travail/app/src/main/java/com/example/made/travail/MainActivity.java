package com.example.made.travail;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;

    Button btnlogin;
    TextView editsinscrire;

    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mydb=new DatabaseHelper(this);


        btnlogin=(Button)findViewById(R.id.boutonlogin);
        editsinscrire=(TextView)findViewById(R.id.editsinscrire);

        username=(EditText) findViewById(R.id.editText_username);
        password=(EditText) findViewById(R.id.editText_password);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(MainActivity.this,formulaireprincipale.class);
                startActivity(intent);

            }
        });

        editsinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,activity_client.class);
                startActivity(intent1);
            }
        });

    }


    }


