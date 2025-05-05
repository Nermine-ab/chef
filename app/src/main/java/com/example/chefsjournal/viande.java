package com.example.chefsjournal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chefsjournal.ui.login.Recette;

import java.util.ArrayList;
import java.util.List;

public class viande extends Fragment {

    private RecyclerView recyclerView;
    private RecetteAdapter adapter;
    private List<Recette> recetteList;

    public viande() {
        // Constructeur vide requis
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viande, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewViande);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recetteList = new ArrayList<>();
        recetteList.add(new Recette("toppoki", "kim", R.drawable.food));
        recetteList.add(new Recette("raviolli", "Yara", R.drawable.img_2));


        RecetteAdapter adapter = new RecetteAdapter(recetteList, recette -> {
            Toast.makeText(getContext(), "Recette sélectionnée : " + recette.getNom(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);



        recyclerView.setAdapter(adapter);

        return view;
    }
}
