package com.example.chefsjournal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chefsjournal.ui.login.Recette;

import java.util.List;

public class RecetteAdapter extends RecyclerView.Adapter<RecetteAdapter.RecetteViewHolder> {

    public interface OnRecetteClickListener {
        void onRecetteClick(Recette recette);
    }

    private final List<Recette> recetteList;
    private final OnRecetteClickListener listener;

    public RecetteAdapter(List<Recette> recetteList, OnRecetteClickListener listener) {
        this.recetteList = recetteList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecetteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recette, parent, false);
        return new RecetteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecetteViewHolder holder, int position) {
        Recette recette = recetteList.get(position);
        holder.bind(recette, listener);
    }

    @Override
    public int getItemCount() {
        return recetteList.size();
    }

    static class RecetteViewHolder extends RecyclerView.ViewHolder {
        ImageView imageRecette;
        TextView textNom;
        TextView textChef;

        public RecetteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRecette = itemView.findViewById(R.id.imageRecette);
            textNom = itemView.findViewById(R.id.textNom);
            textChef = itemView.findViewById(R.id.textChef);
        }

        public void bind(Recette recette, OnRecetteClickListener listener) {
            imageRecette.setImageResource(recette.getImageResId());
            textNom.setText(recette.getNom());
            textChef.setText("Chef: " + recette.getChef());

            itemView.setOnClickListener(v -> listener.onRecetteClick(recette));
        }
    }
}
