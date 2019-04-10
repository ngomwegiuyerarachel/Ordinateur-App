package com.example.made.travail;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ventes extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editid, editname,editprix,editarticle,editnomp;
    DatePicker editdate;
    Button btnAddData;

    Button btn_Add;
    Button btnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventes);;


        editname=(EditText)findViewById(R.id.editText_namecl);
        editnomp=(EditText)findViewById(R.id.editText_nameprop);
        editarticle=(EditText)findViewById(R.id.editText_article);
        editprix=(EditText)findViewById(R.id.editText_prix);
        //editdate=(DatePicker) findViewById(R.id.editText_date);
        btnAddData =(Button)findViewById(R.id.button_add);





        myDb = new DatabaseHelper(this);


        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SQLiteDatabase database = myDb.getWritableDatabase();


                    myDb.close();
                    Toast.makeText(getApplicationContext(), "Enregistrement reussi", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Erreeur", Toast.LENGTH_LONG).show();
                }


            }
        });

            }


    }







