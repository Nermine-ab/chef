package com.example.chefsjournal.ui.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbConnect extends SQLiteOpenHelper {
    private static String dbName = "Chef" ;
    private static int dbVersion = 1;

    private static String ID = "id" ;
    private static String nom = "nom";
    private static String prenom = "prenom";
    private static String username = "username";
    private static String adr = "adr";
    private static String mdp = "mdp" ;
    private static String dbTable = "users";


    public dbConnect(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + dbTable + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                nom + " TEXT, " +
                prenom + " TEXT, " +
                username + " TEXT, " +
                adr + " TEXT, " +
                mdp + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + dbTable);
        onCreate(sqLiteDatabase);
    }

    public void addUser(Users user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(nom, user.getNom());
        values.put(prenom, user.getPrenom());
        values.put(username, user.getUsername());
        values.put(adr, user.getAdr());
        values.put(mdp, user.getMdp());
        db.insert(dbTable, null, values);
        db.close();
    }
    public boolean verifierUtilisateur(String username, String motDePasse) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM users WHERE username=? AND mdp=?",
                new String[]{username, motDePasse}
        );

        boolean existe = (cursor.getCount() > 0);
        cursor.close();
        db.close();

        return existe;
    }


}
