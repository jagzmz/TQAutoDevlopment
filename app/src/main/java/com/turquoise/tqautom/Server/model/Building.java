
package com.turquoise.tqautom.Server.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Building {

    @SerializedName("bd_dum_id")
    @Expose
    private String bdDumId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("floors")
    @Expose
    private List<Floor> floors = null;

    public String getBdDumId() {
        return bdDumId;
    }

    public void setBdDumId(String bdDumId) {
        this.bdDumId = bdDumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public List<Floor> getFloors() {
        return floors;
    }

    @SuppressWarnings("unused")
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

}
