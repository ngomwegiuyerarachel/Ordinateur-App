package com.example.made.travail;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_proprietaire extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editnom,editpostnom,editprenom,editadresse,editcontact;
    Button btnSaveba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proprietaire);
        myDb=new DatabaseHelper(this);


        editnom=(EditText)findViewById(R.id.editnom);
        editpostnom=(EditText)findViewById(R.id.editpostnom);
        editprenom=(EditText)findViewById(R.id.editprenom);
        editadresse=(EditText)findViewById(R.id.editadresse);
        editcontact=(EditText)findViewById(R.id.editcontact);
        btnSaveba =(Button)findViewById(R.id.button_Save);

        btnSaveba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SQLiteDatabase database=myDb.getWritableDatabase();
                    myDb.insertData(editnom.getText().toString(),editpostnom.getText().toString(),editprenom.getText().toString(),editadresse.getText().toString(),Integer.parseInt(editcontact.getText().toString()),database);
                    myDb.close();
                    Toast.makeText(getApplicationContext(),"Enregistrement reussi",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Erreeur",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    }

