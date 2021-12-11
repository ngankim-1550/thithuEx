package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Meal;
import com.example.thithuex.R;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends BaseAdapter {
    Context context;
    List<Meal> meals;
    int item_layout;

    public MealAdapter(Context context, List<Meal> meals, int item_layout) {
        this.context = context;
        this.meals = meals;
        this.item_layout = item_layout;
    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public Object getItem(int i) {
        return meals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(item_layout,null);
            holder.imvThumb=view.findViewById(R.id.imvThumb);
            holder.txtName=view.findViewById(R.id.txtName);
            holder.txtRate=view.findViewById(R.id.txtRate);
            holder.txtRateCount=view.findViewById(R.id.txtRateCount);
            holder.txtAddress=view.findViewById(R.id.txtAddress);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();
        }
        Meal m= meals.get(i);
        holder.txtName.setText(m.getName());
        holder.txtRate.setText(String.format("%.1f",m.getRate()));
        holder.txtRateCount.setText(String.valueOf(m.getRateCount()));
        holder.txtAddress.setText(m.getAddress());
//Convert byte array> bitmap

        holder.imvThumb.setImageResource(m.getImage());
        return view;

    }
    public static class ViewHolder{
        TextView txtName,txtRate,txtRateCount,txtAddress;
        ImageView imvThumb;
    }
}
