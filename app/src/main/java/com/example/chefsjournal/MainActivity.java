package com.example.chefsjournal;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent ;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    EditText editTextNom, editTextMotDePasse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextNom = findViewById(R.id.nomutilisateur);
        editTextMotDePasse = findViewById(R.id.motdepasse);
        findViewById(R.id.sincrire).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        // à faire verification et base de données
        findViewById(R.id.connecter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
                /*String nomUtilisateur = editTextNom.getText().toString();
                String motDePasse = editTextMotDePasse.getText().toString();
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.openI();

                Cursor cursor = databaseAccess.db.rawQuery(
                        "SELECT * FROM Utilisateur WHERE Nom=? AND MotDePasse=?",
                        new String[]{nomutilisateur, motdepasse}
                );

                if (cursor != null && cursor.moveToFirst()) {
                    Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                    // Lancer l'activité principale par exemple
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }

                if (cursor != null) cursor.close();
                databaseAccess.close();*/
            }
        });
    }


}