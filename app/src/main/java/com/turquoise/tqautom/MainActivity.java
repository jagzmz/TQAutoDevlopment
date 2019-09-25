package com.turquoise.tqautom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.turquoise.tqautom.Buildings.CustomAdapter;
import com.turquoise.tqautom.Buttons.ButtonAdapter;
import com.turquoise.tqautom.Floors.FloorInterfaceMapping;
import com.turquoise.tqautom.Floors.FloorAdapter;
import com.turquoise.tqautom.Server.ServerUtil;
import com.turquoise.tqautom.Server.model.Building;
import com.turquoise.tqautom.Server.model.Button;
import com.turquoise.tqautom.Server.model.Floor;
import com.turquoise.tqautom.Server.model.Room;
import com.turquoise.tqautom.Server.model.SwitchBoard;
import com.turquoise.tqautom.Utils.RecyclerDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ServerUtil serverUtil;
    private Building building;
    private LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = MainActivity.this;
        this.serverUtil = new ServerUtil(context);
        serverUtil.getData();
        inflater = LayoutInflater.from(context);

        askForBuilding();

    }

    private void fillFloors(){
        List<FloorInterfaceMapping> mappings= new ArrayList<>();
        for (Floor floor : building.getFloors()) {
            mappings.add(new FloorInterfaceMapping(floor));
        }

        FloorAdapter floorAdapter=new FloorAdapter(context);
        floorAdapter.setFloors(mappings);
        floorAdapter.setHasStableIds(true);

        RecyclerView recyclerView=findViewById(R.id.common_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(floorAdapter);

    }

//    private void fillButtons() {
//        List<Floor> floors = new ArrayList<>();
//        List<FloorInterfaceMapping> mappings= new ArrayList<>();
//        for (Floor floor : building.getFloors()) {
//            for (Room room : floor.getRooms()) {
//                for (SwitchBoard switchBoard : room.getSwitchBoards()) {
//                    for(Button button:switchBoard.getButtons()){
////                        mappings.add(new FloorInterfaceMapping(floor,room,button));
////                        Log.d("Grid", "fillButtons: "+mappings.get(mappings.size()-1).print());
//                    }
//                }
//            }
//        }
//
//        ButtonAdapter buttonAdapter = new ButtonAdapter(context, buttonClickListener);
//        buttonAdapter.setMappings(mappings);
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false));
//        RecyclerDecoration recyclerDecoration=new RecyclerDecoration(context,R.dimen.item_offset);
//        recyclerView.addItemDecoration(recyclerDecoration);
//        recyclerView.setAdapter(buttonAdapter);
//
//
//    }

    private void askForBuilding() {


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final View view = View.inflate(context,R.layout.dialog_building,null);//   inflater.inflate(R.layout.dialog_building,);
        builder.setView(view);
        builder.setCancelable(false);

        List<Building> buildings = serverUtil.getBuildings();
        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        final CustomAdapter customAdapter = new CustomAdapter(context);
        customAdapter.setBuildings(buildings);
        recyclerView.setAdapter(customAdapter);

        builder
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setBuilding(customAdapter.getLastBuilding());
                        populate();

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void populate() {
        if (building != null) {
            fillFloors();
        }
    }

    private void setBuilding(Building building) {
        this.building = building;
    }


}
