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

public class DessertsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecetteAdapter adapter;
    private List<Recette> recetteList;

    public DessertsFragment() {
        // Constructeur vide requis
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desserts, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewDesserts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recetteList = new ArrayList<>();
        recetteList.add(new Recette("Tarte au citron", "Alice", R.drawable.tarte));
        recetteList.add(new Recette("Fondant au chocolat", "Bob", R.drawable.fondant));
        recetteList.add(new Recette("Cheesecake", "Claire", R.drawable.cheesecake));

        RecetteAdapter adapter = new RecetteAdapter(recetteList, recette -> {
            Toast.makeText(getContext(), "Recette sélectionnée : " + recette.getNom(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);



        recyclerView.setAdapter(adapter);

        return view;
    }
}