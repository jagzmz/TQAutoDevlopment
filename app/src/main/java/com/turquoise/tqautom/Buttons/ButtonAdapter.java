package com.turquoise.tqautom.Buttons;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.turquoise.tqautom.R;
import com.turquoise.tqautom.Server.model.Button;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private View view;
    private ButtonViewHolder buttonViewHolder;
    private List<Button> buttons;
    private List<GridMapping> mappings;
//    Map<Floor, Map<Room, Button>> mappings;
    private final String TAG="ButtonAdapter";

    public ButtonAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.button_card,parent,false);
        buttonViewHolder=new ButtonViewHolder(view);
        return buttonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ButtonViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        String buttonName=mappings.get(position).buttonName;
        String floorName=mappings.get(position).floorName;
        String roomName=mappings.get(position).roomName;
        String buttonStatus=mappings.get(position).buttonStatus;

        holder.buttonName.setText(buttonName);
        holder.floorName.setText(floorName);
        holder.roomName.setText(roomName);
        if(buttonStatus.equals("1")){
            holder.colorStatus.setBackgroundColor(context.getResources().getColor(R.color.green));
        }
        else {
            holder.colorStatus.setBackgroundColor(context.getResources().getColor(R.color.buttonOff));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b=mappings.get(position).buttonStatus;
                if(b.equals("0")){
                    mappings.get(position).buttonStatus="1";
                    holder.colorStatus.setBackgroundColor(context.getResources().getColor(R.color.green));
                }
                else {
                    mappings.get(position).buttonStatus="0";
                    holder.colorStatus.setBackgroundColor(context.getResources().getColor(R.color.buttonOff));
                }
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mappings.size();
    }

    public void setButtons(List<Button> buttons){
        this.buttons=buttons;
        notifyItemRangeChanged(0,buttons.size());
    }

    public void setMappings(List<GridMapping> mappings) {
        this.mappings=mappings;
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder {

        final LinearLayout colorStatus;
        final TextView buttonName;
        final TextView roomName;
        final TextView floorName;
        final CardView cardView;
        ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            colorStatus = itemView.findViewById(R.id.colorStatus);
            buttonName = itemView.findViewById(R.id.buttonName);
            cardView=itemView.findViewById(R.id.buttonCard);
            roomName=itemView.findViewById(R.id.roomName);
            floorName=itemView.findViewById(R.id.floorName);
        }
    }

}
