
package com.turquoise.tqautom.Server.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Floor {

    @SerializedName("flr_dum_id")
    @Expose
    private String flrDumId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rooms")
    @Expose
    private List<Room> rooms = null;

    @SuppressWarnings("unused")
    public String getFlrDumId() {
        return flrDumId;
    }

    public void setFlrDumId(String flrDumId) {
        this.flrDumId = flrDumId;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}
