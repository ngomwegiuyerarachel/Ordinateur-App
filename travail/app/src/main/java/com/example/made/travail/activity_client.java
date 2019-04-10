package com.example.made.travail;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_client extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editid, editname,editage,editusername,editpassword;
    Button btnAddData;
    Button btn_Add;


    Button btnviewupdate;

    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);




        editname=(EditText)findViewById(R.id.editText_name);
        editage=(EditText)findViewById(R.id.editText_age);
        editusername=(EditText)findViewById(R.id.editText_username);
       editpassword=(EditText)findViewById(R.id.editText_password);
        btnAddData =(Button)findViewById(R.id.button_add);




        myDb = new DatabaseHelper(this);




        btnAddData.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
         try {
         SQLiteDatabase database = myDb.getWritableDatabase();
             myDb.insertData(editname.getText().toString(),Integer.parseInt(editage.getText().toString())
                     ,editusername.getText().toString(),editpassword.getText().toString(),database);
          myDb.close();
          Toast.makeText(getApplicationContext(), "Enregistrement reussi", Toast.LENGTH_LONG).show();
         } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Erreeur", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
