package com.example.made.travail;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class paiement extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editmodepaiement;
    Button btnsave;
    AutoCompleteTextView suggestio_box;
    Spinner items;
    ArrayList<String> food =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement);

        myDb=new DatabaseHelper(this);



       editmodepaiement=(EditText)findViewById(R.id.edit_mode_paiement);
        btnsave=(Button)findViewById(R.id.btn_add);
       // suggestio_box=(AutoCompleteTextView)findViewById(R.id.suggectio_box);
       // items=(Spinner) findViewById(R.id.items);
        //food.add("projecteur");
        //food.add("telephone");
        //food.add("ecrans");
        //food.add("souris");
        //food.add("ordinateur");
        //food.add("ordi");
        //food.add("or");
        //food.add("ord");
        //food.add("clavier");
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>
          //      (paiement.this,android.R.layout.simple_spinner_dropdown_item,food);
        //ArrayAdapter<String> adapter1=new ArrayAdapter<String>
          //      (paiement.this,android.R.layout.simple_spinner_dropdown_item,food);
        //suggestio_box.setAdapter(adapter);
        //items.setAdapter(adapter1);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SQLiteDatabase database=myDb.getWritableDatabase();
                    myDb.insertpaiement(editmodepaiement.getText().toString(),database);
                    myDb.close();
                    Toast.makeText(getApplicationContext(),"Enregistrement reussi",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Erreeur",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
