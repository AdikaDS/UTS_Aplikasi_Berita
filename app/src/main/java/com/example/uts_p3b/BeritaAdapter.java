package com.example.uts_p3b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    ArrayList<BeritaListItem> listBerita;
    Context context;

    public BeritaAdapter(ArrayList<BeritaListItem> list) {
        this.listBerita = list;
    }

    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.berita_item_list, parent,false);
        return new BeritaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.BeritaViewHolder holder, int position) {
        final BeritaListItem news = listBerita.get(position);

        holder.tvJudulBerita.setText(news.getJudulBerita());
        holder.tvAuthor.setText(news.getAuthors());
        holder.tvIsiBerita.setText(news.getIsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailBerita.class);
                Bundle bundle = new Bundle();

                bundle.putString("title", news.getJudulBerita());
                bundle.putString("author", news.getAuthors());
                bundle.putString("isi", news.getIsi());
                bundle.putInt("picture", news.getGambarBerita());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    public class BeritaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBerita;
        TextView tvJudulBerita, tvAuthor, tvIsiBerita;

        public BeritaViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imgBerita = itemView.findViewById(R.id.gambar_berita);
            tvJudulBerita = itemView.findViewById(R.id.judul);
            tvAuthor = itemView.findViewById(R.id.author);
            tvIsiBerita = itemView.findViewById(R.id.isi_berita);
        }
    }
}
