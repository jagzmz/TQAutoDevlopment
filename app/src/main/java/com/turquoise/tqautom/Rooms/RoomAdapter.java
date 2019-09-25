package com.turquoise.tqautom.Rooms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.turquoise.tqautom.Buttons.ButtonAdapter;
import com.turquoise.tqautom.Buttons.ButtonClickListener;
import com.turquoise.tqautom.R;
import com.turquoise.tqautom.Server.model.Button;
import com.turquoise.tqautom.Server.model.Room;
import com.turquoise.tqautom.Server.model.SwitchBoard;
import com.turquoise.tqautom.Utils.RecyclerDecoration;

import java.util.ArrayList;
import java.util.List;


public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private View view;
    private RoomViewHolder roomViewHolder;
    private List<Room> rooms;

    public RoomAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.room_view_interface, parent, false);
        roomViewHolder = new RoomViewHolder(view);
        return roomViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.roomName.setText(rooms.get(position).getName());
        List<Button> buttons = new ArrayList<>();

        for (SwitchBoard switchBoard : rooms.get(position).getSwitchBoards()) {
            buttons.addAll(switchBoard.getButtons());
        }


        holder.setButtons(buttons);
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
        notifyDataSetChanged();
    }

    class RoomViewHolder extends RecyclerView.ViewHolder implements ButtonClickListener {

        final TextView roomName, inUse;
        final RecyclerView buttonRecyclerView;

        RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.roomName = itemView.findViewById(R.id.roomName);
            this.inUse = itemView.findViewById(R.id.buttonsInUse);
            this.buttonRecyclerView = itemView.findViewById(R.id.button_recycler_view);
        }

        void setButtons(List<Button> buttons) {
            ButtonClickListener buttonClickListener = this;
            ButtonAdapter buttonAdapter = new ButtonAdapter(context, buttonClickListener);
            buttonAdapter.setButtons(buttons);
            buttonRecyclerView.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
            RecyclerDecoration recyclerDecoration = new RecyclerDecoration(context, R.dimen.item_offset1);
            buttonRecyclerView.addItemDecoration(recyclerDecoration);
            buttonRecyclerView.setAdapter(buttonAdapter);
        }

        @Override
        public void callback(int trigger) {
            int cur = Integer.valueOf(inUse.getText().toString());

            if (trigger == 0) {
                if (cur != 0) {
                    cur--;
                }
            } else {
                cur++;
            }
            inUse.setText(String.valueOf(cur));
        }
    }
}
