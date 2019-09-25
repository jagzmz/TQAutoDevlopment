
package com.turquoise.tqautom.Server.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Customer {

    @SerializedName("cw_dum_id")
    @Expose
    private String cwDumId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("buildings")
    @Expose
    private List<Building> buildings = null;

    public String getCwDumId() {
        return cwDumId;
    }

    @SuppressWarnings("unused")
    public void setCwDumId(String cwDumId) {
        this.cwDumId = cwDumId;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

}
