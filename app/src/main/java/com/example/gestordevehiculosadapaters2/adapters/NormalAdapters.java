package com.example.gestordevehiculosadapaters2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestordevehiculosadapaters2.R;
import com.example.gestordevehiculosadapaters2.models.Item;

import java.util.List;

public class NormalAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;
    private OnItemActionListener listener;

    public interface OnItemActionListener {
        void onItemClick(Item item, int position);
        void onActionButtonClick(Item item, int position);
    }

    public NormalAdapters(List<Item> items, OnItemActionListener listener) {
        this.items = items;
        this.listener = listener;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pp, parent, false);
        return new ActiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);

        if (holder instanceof ActiveViewHolder) {
            bindActiveViewHolder((ActiveViewHolder) holder, item, position);
        } else if (holder instanceof InactiveViewHolder) {
            bindInactiveViewHolder((InactiveViewHolder) holder, item, position);
        }
    }

    private void bindActiveViewHolder(ActiveViewHolder holder, Item item, int position) {
        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());
        holder.ivImage.setImageResource(item.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item, position);
            }
        });

        holder.btnAction.setOnClickListener(v -> {
            if (listener != null) {
                listener.onActionButtonClick(item, position);
            }
        });
    }

    private void bindInactiveViewHolder(InactiveViewHolder holder, Item item, int position) {
        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());
        holder.ivImage.setImageResource(item.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item, position);
            }
        });

        holder.btnAction.setOnClickListener(v -> {
            if (listener != null) {
                listener.onActionButtonClick(item, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ActiveViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        ImageView ivImage;
        ImageButton btnAction;

        public ActiveViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivImage = itemView.findViewById(R.id.ivImage);
            btnAction = itemView.findViewById(R.id.btnAction);
        }
    }

    public static class InactiveViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        ImageView ivImage;
        ImageButton btnAction;

        public InactiveViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivImage = itemView.findViewById(R.id.ivImage);
            btnAction = itemView.findViewById(R.id.btnAction);
        }
    }
}