package com.example.chefsjournal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ListView listViewCategories;

    // Liste des catégories
    private final String[] categories = {
            "🍲 Soupes et 🥗 Salades",
            "🥩 Viandes et 🍝 Pâtes",
            "🍰 Desserts",
            "🍞 Pain & Viennoiseries",


    };




    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listViewCategories = view.findViewById(R.id.listViewCategories);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                R.layout.item_category,
                R.id.textCategory,
                categories
        );
        listViewCategories.setAdapter(adapter);
        listViewCategories.setOnItemClickListener((parent, view1, position, id) -> {
            Fragment selectedFragment;

            switch (position) {
                case 0:
                    selectedFragment = new soupes();
                    break;
                case 1:
                    selectedFragment = new viande();
                    break;
                case 2:
                    selectedFragment = new DessertsFragment();
                    break;
                case 3:
                    selectedFragment = new pain();
                    break;
                default:
                    selectedFragment = null;
            }

            if (selectedFragment != null) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment) // ID de ton conteneur dans l'activity
                        .addToBackStack(null)
                        .commit();
            }
        });




        return view;
    }
}
