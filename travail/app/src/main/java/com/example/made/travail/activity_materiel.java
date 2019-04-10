package com.example.made.travail;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static android.content.Intent.ACTION_PICK;


public class activity_materiel extends AppCompatActivity  {

    ImageView imageView;
    Button btnchoix;
    Bitmap bitmap;
    final int REQUEST_CODE_GALLERY = 999;
    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;

    DatabaseHelper myDb;
    EditText editname, editprix, editphotoarticle;
    Button btnAddphoto;
    Button btnadd;
    Button btnlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiel);


        btnchoix = (Button) findViewById(R.id.btnchoisir);

        myDb = new DatabaseHelper(this);
        editname = (EditText) findViewById(R.id.editname);
        editprix = (EditText) findViewById(R.id.editprix);
        imageView = (ImageView) findViewById(R.id.editphotoarticle);
        btnAddphoto = (Button) findViewById(R.id.btnchoisir);
        btnadd = (Button) findViewById(R.id.btadd);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SQLiteDatabase database = myDb.getWritableDatabase();
                    myDb.insertData(editname.getText().toString(), editprix.getText().toString(), imageViewToByte(imageView), database);
                    myDb.close();
                    Toast.makeText(getApplicationContext(), "Enregistrement reussi", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Erreeur", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnchoix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });


    }


    private void SelectImage() {


        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity_materiel.this);
        builder.setTitle("Add Image");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (items[i].equals("Camera")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[i].equals("Gallery")) {
                    Intent intent = new Intent(ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent, SELECT_FILE);
                } else if (items[i].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getApplicationContext(),
                        "You don't have permission to access to this file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {

                Bundle bundle = data.getExtras();
                //final Bitmap bmp=(Bitmap) bundle.get("data");
                bitmap = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bitmap);
            } else if (requestCode == SELECT_FILE) {
                Uri selectImageUri = data.getData();

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectImageUri);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //InputStream inputStream=getContentResolver().openInputStream(selectImageUri);
                //bitmap=BitmapFactory.decodeStream(inputStream);
                //bitmapInsert=bitmap;
                //imageView.setImageBitmap(bitmap);


            }


        }

    }



    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


}