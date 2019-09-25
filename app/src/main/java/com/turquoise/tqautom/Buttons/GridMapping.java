package com.turquoise.tqautom.Buttons;

import com.turquoise.tqautom.Server.model.Button;
import com.turquoise.tqautom.Server.model.Floor;
import com.turquoise.tqautom.Server.model.Room;

public class GridMapping {
    final String floorName;
    final String roomName;
    final String buttonName;
    String buttonStatus;

    public GridMapping(Floor floorName, Room roomName, Button buttonName) {
        this.floorName = floorName.getName();
        this.roomName = roomName.getName();
        this.buttonName = buttonName.getButAlias();
        this.buttonStatus = buttonName.getButStatus();
    }

    public String print(){
        return "print: "+floorName+" "+roomName+" "+buttonName+" "+buttonStatus;
    }
}
