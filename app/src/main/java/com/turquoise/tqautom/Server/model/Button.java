package com.turquoise.tqautom.Server.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Button {

    @SerializedName("but_dum_id")
    @Expose
    private String butDumId;
    @SerializedName("but_status")
    @Expose
    private String butStatus;
    @SerializedName("but_alias")
    @Expose
    private String butAlias;

    public String getButDumId() {
        return butDumId;
    }

    public void setButDumId(String butDumId) {
        this.butDumId = butDumId;
    }

    public String getButStatus() {
        return butStatus;
    }

    public void setButStatus(String butStatus) {
        this.butStatus = butStatus;
    }

    public String getButAlias() {
        return butAlias;
    }

    public void setButAlias(String butAlias) {
        this.butAlias = butAlias;
    }

}