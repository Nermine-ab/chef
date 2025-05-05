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
import android.widget.Toast;
import com.example.chefsjournal.ui.login.dbConnect;

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
                String nomUtilisateur = editTextNom.getText().toString().trim();
                String motDePasse = editTextMotDePasse.getText().toString().trim();

                if (nomUtilisateur.isEmpty() || motDePasse.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbConnect db = new dbConnect(MainActivity.this);
                boolean utilisateurValide = db.verifierUtilisateur(nomUtilisateur, motDePasse); // méthode à créer

                if (utilisateurValide) {
                    Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    intent.putExtra("name", nomUtilisateur);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}