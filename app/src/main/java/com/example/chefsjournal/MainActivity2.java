package com.example.chefsjournal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.content.ContentValues ;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText ;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import com.example.chefsjournal.ui.login.dbConnect;
import com.example.chefsjournal.ui.login.Users;

public class MainActivity2 extends AppCompatActivity {
    EditText nom,prenom,username,email,mdp,cmdp ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(MainActivity2.this,nom.getText().toString(),Toast.LENGTH_LONG).show();*/
                boolean t = true ;
                nom = (EditText)findViewById(R.id.nom);
                prenom = (EditText)findViewById(R.id.prenom);
                username = (EditText)findViewById(R.id.user);
                email = (EditText)findViewById(R.id.email);
                mdp = (EditText)findViewById(R.id.mdp);
                cmdp = (EditText)findViewById(R.id.cmdp);
                if(nom.getText().toString().isEmpty() || est_alpha(nom.getText().toString())==false ){
                    Toast.makeText(MainActivity2.this,"nom invalid",Toast.LENGTH_LONG).show();
                    t = false;
                }
                else if(prenom.getText().toString().isEmpty() || est_alpha(prenom.getText().toString())==false ){
                    Toast.makeText(MainActivity2.this,"prenom invalid",Toast.LENGTH_LONG).show();
                    t = false;
                }
                else if(username.getText().toString().isEmpty() || username.getText().toString().length() >10 ){
                    Toast.makeText(MainActivity2.this,"username invalid",Toast.LENGTH_LONG).show();
                    t = false;
                }
                else if(email.getText().toString().isEmpty() || !email.getText().toString().endsWith("@gmail.com" )){
                    Toast.makeText(MainActivity2.this,"email invalid",Toast.LENGTH_LONG).show();
                    t = false;
                }
                else if(mdp.getText().toString().compareTo(cmdp.getText().toString())!=0){
                    Toast.makeText(MainActivity2.this,"Confirmation mot de passe invalid",Toast.LENGTH_LONG).show();
                    t = false;

                }
                else if(mdp.getText().toString().isEmpty() || verifier_mot_passe(mdp.getText().toString())==false){
                    Toast.makeText(MainActivity2.this,"mot de passe invalid",Toast.LENGTH_LONG).show();
                    t = false;

                }
                if (t) {
                    Users user = new Users(
                            nom.getText().toString(),
                            prenom.getText().toString(),
                            username.getText().toString(),
                            email.getText().toString(),
                            mdp.getText().toString()
                    );
                    dbConnect db = new dbConnect(MainActivity2.this);
                    db.addUser(user);
                    Toast.makeText(MainActivity2.this, "Inscription réussie", Toast.LENGTH_LONG).show();
                    // DEBUG : afficher tous les utilisateurs après inscription
                    SQLiteDatabase dbRead = db.getReadableDatabase();
                    Cursor cursor = dbRead.rawQuery("SELECT * FROM users", null);
                    while (cursor.moveToNext()) {
                        String userDebug = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                        String passDebug = cursor.getString(cursor.getColumnIndexOrThrow("mdp"));
                        Toast.makeText(MainActivity2.this, "DEBUG: " + userDebug + " / " + passDebug, Toast.LENGTH_LONG).show();
                    }
                    cursor.close();

                    finish(); // pour retourner à l'activité précédente
                }



            }
        });

    }
    public void onClickFinish(View view) {
        finish();
    }
    public boolean est_alpha(String str) {
        return str.matches("[a-zA-Z]+");
    }
    public boolean verifier_mot_passe(String ch) {
        boolean t = true;
        int nbmaj = 0;
        int nbnum = 0;
        int nbmin = 0;
        for (int i = 0; i < ch.length(); i++) {
            if (ch.charAt(i) >= 'A' && ch.charAt(i) <= 'Z') {
                nbmaj = nbmaj + 1;
            } else if (ch.charAt(i) >= 'a' && ch.charAt(i) <= 'z') {
                nbmin = nbmin + 1;

            } else if (ch.charAt(i) >= '0' && ch.charAt(i) <= '9') {
                nbnum = nbnum + 1;
            } else {
                t = false;
            }
        }
        if ((nbmaj >= 1 && nbmin >= 1 && nbnum >= 1) && t == true) {
            return true;
        } else {
            return false;
        }
    }


}

