package com.turquoise.tqautom.Buildings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turquoise.tqautom.R;
import com.turquoise.tqautom.Server.model.Building;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<Building> list_members = new ArrayList<>();
    private final LayoutInflater inflater;
    private View view;
    private MyViewHolder holder;
    private final Context context;
    private Building lastBuilding;
    private boolean defaultButton;

    private CheckBox lastCheckBox;
    private int lastPos = 0;

    public CustomAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.custom_bding_row, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Building building = list_members.get(position);
        holder.bname.setText(building.getName());
        holder.noFloors.setText(String.valueOf(building.getFloors().size()));
//        holder.setPos(position);
        holder.rButton.setChecked(position == lastPos);

        if (!defaultButton) {
            lastCheckBox = holder.rButton;
            defaultButton = !defaultButton;
            lastCheckBox.setChecked(defaultButton);
//            holder.setPos(position);
        }

        holder.rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lastPos!=position) {
                    lastCheckBox.setChecked(false);
                    lastCheckBox = (CheckBox)v;
                    lastPos=position;
                }
                else{
                    lastCheckBox.setChecked(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    public Building getLastBuilding() {
        return list_members.get(lastPos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView bname;
        final TextView noFloors;
        final CheckBox rButton;
        int pos;

        MyViewHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);
            bname = itemView.findViewById(R.id.buildinName);
            noFloors = itemView.findViewById(R.id.noFloors);
            rButton = itemView.findViewById(R.id.selectedBuilding);

        }


        public void setPos(int position) {
            pos = position;
        }
    }

    public void setBuildings(List<Building> buildings) {
        this.list_members = buildings;
        notifyItemRangeChanged(0, list_members.size());
    }


}

