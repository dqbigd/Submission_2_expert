package com.example.submission_2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewViewHolder> {
    private ArrayList<Film> listFilm;

    public FilmAdapter(ArrayList<Film> list){
        this.listFilm = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, final int position) {
        Film film = listFilm.get(position);

        Glide.with(holder.itemView.getContext()).load(film.getPhoto()).into(holder.imgPhoto);
        holder.tvTitle.setText(film.getName());
        holder.tvDecs.setText(film.getDesc());

    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvTitle, tvDecs;

        public CardViewViewHolder(@NonNull View itemView)  {
            super(itemView);
            itemView.setOnClickListener(this);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            tvTitle = itemView.findViewById(R.id.txtJudul);
            tvDecs = itemView.findViewById(R.id.txtDesc);
        }

        @Override
        public void onClick(View view) {

            Intent intentDetail = new Intent(view.getContext(), DetailFilmActivity.class);

            intentDetail.putExtra(DetailFilmActivity.EXTRA_FILM, listFilm.get(getAdapterPosition()));
            view.getContext().startActivity(intentDetail);

        }
    }
}

