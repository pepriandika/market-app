package com.pendka.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    //properties
    private List<Item> itemList;
    public ItemClickListener clickListener;

    public void setClickListener(ItemClickListener mylistener) {
        this.clickListener = mylistener;
    }

    //contructor
    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Bertugas untuk membuat 'view holder' baru untuk item-item Anda.
        // Ketika RecyclerView perlu menampilkan item baru,
        // ia akan meminta adapter untuk membuat view holder baru.
        // Adapter kemudian akan membuat instance dari kelas view holder Anda dan
        // mengembalikannya ke RecyclerView.
        // Dengan kata lain, kode yang Anda tulis untuk membuat view holder baru akan
        // menentukan bagaimana setiap item dalam daftar Anda akan ditampilkan.
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDesc());
        holder.imageView.setImageResource(item.getImg());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //inner class
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // view holder adalah objek yang menyimpan referensi ke tampilan individual dalam daftar.
        // View holder bertanggung jawab untuk mengikat data ke tampilan tersebut.
        ImageView imageView;
        TextView title;
        TextView desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title_text);
            desc = itemView.findViewById(R.id.description_text);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null) {
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}
