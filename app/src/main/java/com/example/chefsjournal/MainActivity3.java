package com.example.chefsjournal;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent ;
import android.widget.Toast ;
import android.widget.TextView ;
import com.google.android.material.navigation.NavigationBarView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;

public class MainActivity3 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        /*//afficher menul_home par defaut
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();*/
        Intent intent = getIntent();
        String s1 = intent.getExtras().getString("name");
        TextView textView = findViewById(R.id.textViewBienvenue);
        textView.setText("Bienvenue " + s1);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selected_fragment = null ;

                int id = item.getItemId();
                if(id == R.id.menu_home){
                    selected_fragment = new HomeFragment() ;
                }

                else if(id == R.id.menu_user){
                    selected_fragment = new userFragment() ;
                }
                if (selected_fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selected_fragment).commit();
                }
                return true ;
            }
        });

    }
}