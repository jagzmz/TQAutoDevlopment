
package com.turquoise.tqautom.Server.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Room {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("switch_boards")
    @Expose
    private List<SwitchBoard> switchBoards = null;

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public List<SwitchBoard> getSwitchBoards() {
        return switchBoards;
    }

    @SuppressWarnings("unused")
    public void setSwitchBoards(List<SwitchBoard> switchBoards) {
        this.switchBoards = switchBoards;
    }

}
