package com.turquoise.tqautom.Floors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.turquoise.tqautom.Buttons.ButtonAdapter;
import com.turquoise.tqautom.R;
import com.turquoise.tqautom.Rooms.RoomAdapter;
import com.turquoise.tqautom.Server.model.Floor;
import com.turquoise.tqautom.Server.model.Room;

import java.util.List;

public class FloorAdapter extends RecyclerView.Adapter<FloorAdapter.FloorViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private View view;
    private FloorViewHolder floorViewHolder;
    private List<FloorInterfaceMapping> floors;
    public FloorAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FloorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view=inflater.inflate(R.layout.floor_view_interface,parent,false);
        floorViewHolder=new FloorViewHolder(view);
        return floorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FloorViewHolder holder, int position) {

        //Setting Floor Name
        holder.setFloorName(floors.get(position).floorName);
        holder.setRooms(floors.get(position).getRooms());




    }

    @Override
    public int getItemCount() {
        return floors.size();
    }

    public void setFloors(List<FloorInterfaceMapping> mappings){
        this.floors=mappings;
        notifyDataSetChanged();
    }

    class FloorViewHolder extends RecyclerView.ViewHolder{
        final TextView floorName;
//        final LinearLayout roomLayout;
        private RecyclerView roomRecyclerView;
        private ButtonAdapter buttonAdapter;
        private List<Room> rooms;
        FloorViewHolder(@NonNull View itemView) {
            super(itemView);
            floorName=itemView.findViewById(R.id.floorName);
            roomRecyclerView=itemView.findViewById(R.id.room_recycler_view);

        }

        void setFloorName(String floorName){
            this.floorName.setText(floorName);
        }

        void setRooms(List<Room> rooms) {
            RoomAdapter roomAdapter=new RoomAdapter(context);
            roomAdapter.setRooms(rooms);
            roomRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            roomRecyclerView.setAdapter(roomAdapter);
            this.rooms=rooms;

        }
    }
}
