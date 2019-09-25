package com.turquoise.tqautom.Floors;

import com.turquoise.tqautom.Server.model.Floor;
import com.turquoise.tqautom.Server.model.Room;

import java.util.List;

public class FloorInterfaceMapping {
    final String floorName;
    private List<Room> roomList;

    public FloorInterfaceMapping(Floor floor) {
        this.floorName = floor.getName();
        roomList=floor.getRooms();
    }

    public List<Room> getRooms(){
        return roomList;
    }

}
