package com.example.made.travail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.DatePicker;

import java.sql.Blob;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ventes.db";
    public static final int DATABASE_VER = 1;


    public static final String TABLE_NAME = "client_table";
    public static final String TABLE_NAMEE = "proprietaire";
    public static final String TABLE_NAME1 = "materiel";
    public static final String TABLE_NAME2 = "acheter";
    public static final String TABLE_NAME3 = "ventes";


    public static final String COL_id = "IDcl";
    public static final String COL_name = "NAME";
    public static final String COL_age = "AGE";
    public static final String COL_user = "USER_NAME";
    public static final String COL_pass = "PASSWORD";


    public static final String COL_idp = "IDpro";
    public static final String COL_nomp = "NOM";
    public static final String COL_postp = "POST_NOM";
    public static final String COL_prep = "PRE_NOM";
    public static final String COL_adre = "Adresse";

    public static final String COL_contactp = "CONTACT";

    public static final String COL_idmat = "IDmat";
    public static final String COL_NAME = "name";
    public static final String COL_PRIX = "prix";
    public static final String COL_image = "image";

    public static final String COL_idach = "IDach";
    public static final String COL_mode = "mode_de_paiement";


    public static final String COL_idv = "IDv";
    public static final String COL_nomclent = "Nomclient";
    public static final String COL_nomproprietaire ="Nomproprietaire";
    public static final String COL_article = "article";
    public static final String COL_prix = "prix";
    public static final String COL_Dateenr = "dateenr";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(IDcl INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AGE TEXT,USER_NAME TEXT,PASSWORD TEXT)");

        db.execSQL("create table " + TABLE_NAMEE + "(IDpro INTEGER PRIMARY KEY AUTOINCREMENT,NOM TEXT,POST_NOM TEXT,PRE_NOM TEXT,ADRESSE TEXT,CONTACT INTEGER)");


        db.execSQL("create table " + TABLE_NAME1 + "(IDmat INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRIX TEXT,IMAGE Byte not null)");


        db.execSQL("create table " + TABLE_NAME2 + "(IDach INTEGER PRIMARY KEY AUTOINCREMENT,mode_de_paiement TEXT not null)");


        db.execSQL("create table " + TABLE_NAME3 + "(IDv INTEGER PRIMARY KEY AUTOINCREMENT,Nomclient TEXT NOT NULL,Nomproprietaire TEXT,article TEXT,prix TEXT,dateenr TEXT)");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMEE);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);

    }


    public void insertData(String NAME, Integer AGE, String USER_NAME, String PASSWORD, SQLiteDatabase db) {

        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_name, NAME);
        contentvalues.put(COL_age, AGE);
        contentvalues.put(COL_user, USER_NAME);
        contentvalues.put(COL_pass, PASSWORD);

        db.insert(TABLE_NAME, null, contentvalues);


    }


    public void insertData(String nom, String post_nom, String pre_nom, String Adresse, Integer contact, SQLiteDatabase db) {
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COL_nomp, nom);
        contentvalues.put(COL_postp, post_nom);
        contentvalues.put(COL_prep, pre_nom);
        contentvalues.put(COL_adre, Adresse);
        contentvalues.put(COL_contactp, contact);


        db.insert(TABLE_NAMEE, null, contentvalues);


    }

    public void insertData(String Name, String Prix, byte[] image, SQLiteDatabase db) {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_NAME, Name);
        contentvalues.put(COL_PRIX, Prix);
        contentvalues.put(COL_image, image);


        db.insert(TABLE_NAME1, null, contentvalues);


    }

    public void insertpaiement(String mode_de_paiement, SQLiteDatabase db) {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_mode, mode_de_paiement);


        db.insert(TABLE_NAME2, null, contentvalues);


    }
    public void insertData(String Nomclient, String Nomproprietaire , String article, String prix,  String dateenr, SQLiteDatabase db) {
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COL_nomclent, Nomclient);
        contentvalues.put(COL_nomproprietaire, Nomproprietaire);
        contentvalues.put(COL_article,article );
        contentvalues.put(COL_prix, prix);
        contentvalues.put(COL_Dateenr, dateenr);


        db.insert(TABLE_NAMEE, null, contentvalues);


    }


    //public static final String COL_idmat = "IDmat";
    //public static final String COL_NAME = "name";
    //public static final String COL_PRIX = "prix";
   // public static final String COL_image = "image";

    public ArrayList<clsclient> testechargementclient(){

        int teste=0;
        ArrayList<clsclient> list=new ArrayList<clsclient>();
        SQLiteDatabase db=this.getReadableDatabase();
        db.beginTransaction();
        try{
            String selectQuery="SELECT * FROM "+TABLE_NAME1+" ";
            //String selectQuery="SELECT * FROM "+Dbpaiemobile.TABLE_NAME_CLIENT+" ";
            Cursor cursor=db.rawQuery(selectQuery,null);
            if(cursor.getCount()>=1){
                teste=1;
                list.clear();
                while(cursor.moveToNext()){
                    //usersession.getInstance().setId(cursor.getString(cursor.getColumnIndex(Dbpaiemobile.CODE_CLIENT)));
                    Integer id=cursor.getInt(cursor.getColumnIndex("IDmat"));
                    String nom=cursor.getString(cursor.getColumnIndex("NAME"));
                    String prix=cursor.getString(cursor.getColumnIndex("PRIX"));
                    byte[] image=cursor.getBlob(cursor.getColumnIndex("IMAGE"));


                    list.add(new clsclient(id,nom,prix,image));

                }
            }
            else{
                teste=0;
            }
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
            db.close();
        }

        return  list;
    }


    public int testeloginuser(String name,String password){

        int teste=0;
        SQLiteDatabase db=this.getReadableDatabase();
        db.beginTransaction();
        try{
            String selectQuery="SELECT * FROM "+TABLE_NAME+" WHERE USER_NAME= '"+name+"' AND PASSWORD TEXT = '"+password+"' ";
            //String selectQuery="SELECT * FROM "+Dbpaiemobile.TABLE_NAME_CLIENT+" ";
            Cursor cursor=db.rawQuery(selectQuery,null);
            if(cursor.getCount()==1){
                teste=1;
                while(cursor.moveToNext()){
                    int code=cursor.getInt(cursor.getColumnIndex("IDcl"));
                }
            }
            else{
                teste=0;
            }
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
            db.close();
        }

        return  teste;
    }







//    public void insertData(String pnaume, SQLiteDatabase db) {
//        db.beginTransaction();
//        ContentValues values;
//        try {
//
//
//            values = new ContentValues();
//            values.put("pnaume", pnaume);
//            db.insert(TABLE_NAME3, null, values);
//            db.setTransactionSuccessful();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            db.endTransaction();
//            db.close();
//        }
//        public ArrayList<String> getAllMode(){
//            ArrayList<String> list = new ArrayList<String>();
//            SQLiteDatabase database = this.getReadableDatabase();
//            db.beginTransaction();
//
//                String selecteQuerry = "select * From " + TABLE_NAME3;
//                Cursor cursor = db.rawQuery(selecteQuerry, null);
//                if (cursor.getCount() > 0) ;
//                while (cursor.moveToNext()) {
//
//                    String pnaume = cursor.getString(cursor.getColumnIndex("pnaume"));
//                    list.add(pnaume);
//                }
//            }
//        db.setTransactionSuccessful();


        }
      //  }





      //  ContentValues contentvalues = new ContentValues();
      //  contentvalues.put(COL_nomcl,nomclient );
       // contentvalues.put(COL_adresse, Adresseclient);
       // contentvalues.put(COL_nompro, nompropietaire);
       // contentvalues.put(COL_modede, modedepaiement);
       // contentvalues.put(COL_date, Dateenr);
       // contentvalues.put(COL_imagec, IMAGE);



       ///// db.insert(TABLE_NAME3, null, contentvalues);




    







