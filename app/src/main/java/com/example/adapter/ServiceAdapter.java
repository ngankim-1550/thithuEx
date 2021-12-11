package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Service;
import com.example.thithuex.R;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {
    Context context;
    ArrayList<Service> services;

    public ServiceAdapter(Context context, ArrayList<Service> services) {
        this.context = context;
        this.services = services;
    }

    @NonNull
    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View custom_view = inflater.inflate(R.layout.item_layout_recycleview,parent,false);
        return new ViewHolder(custom_view);

    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ViewHolder holder, int position) {
        holder.imvPhoto.setImageResource(services.get(position).getImage());
        holder.txtInfo.setText(services.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return services.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvPhoto;
        TextView txtInfo;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            //link view
            imvPhoto=itemView.findViewById(R.id.imvThumb);
            txtInfo=itemView.findViewById(R.id.txtName);

        }
    }
}
