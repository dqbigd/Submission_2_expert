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

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {
    private ArrayList<Tv> listTv;

    public TvAdapter(ArrayList<Tv> list){
        this.listTv = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tv tv = listTv.get(position);

        Glide.with(holder.itemView.getContext()).load(tv.getPhoto()).into(holder.imgPhoto);
        holder.tvTitle.setText(tv.getName());
        holder.tvDecs.setText(tv.getDesc());
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView tvTitle, tvDecs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            tvTitle = itemView.findViewById(R.id.txtJudul);
            tvDecs = itemView.findViewById(R.id.txtDesc);
        }

        @Override
        public void onClick(View view) {

            Intent intentDetail = new Intent(view.getContext(), DetailTvActivity.class);

            intentDetail.putExtra(DetailTvActivity.EXTRA_TV, listTv.get(getAdapterPosition()));
            view.getContext().startActivity(intentDetail);
        }
    }
}
