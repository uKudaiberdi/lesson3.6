package com.example.lesson36;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson36.databinding.ItemFlagBinding;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MaimViewHolder> {

    private ArrayList<Model> data;
    private onClick onClick;

    public MainAdapter(ArrayList<Model> data, com.example.lesson36.onClick onClick) {
        this.data = data;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public MaimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MaimViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flag,parent, false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MaimViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MaimViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;

        public MaimViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.TextView);
            image = itemView.findViewById(R.id.imageAmerica);
        }

        public void bind(Model model) {
            name.setText(model.getText());
            image.setImageResource(model.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.onClick(data.get(getLayoutPosition()));
                }
            });
        }
    }
}
