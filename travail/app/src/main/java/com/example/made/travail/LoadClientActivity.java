package com.example.made.travail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class LoadClientActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_client);

        gridView=(GridView) findViewById(R.id.gridView);

        ArrayList<clsclient> list=new ArrayList<clsclient>();
        DatabaseHelper databaseHelper=new DatabaseHelper(this);

        list=databaseHelper.testechargementclient();
        ClinetAdapter adapter=new ClinetAdapter(this,R.layout.activity_client_layout,list);
        gridView.setAdapter(adapter);



    }




}
