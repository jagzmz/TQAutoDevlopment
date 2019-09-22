
package com.turquoise.tqautom.Server.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Button {

    @SerializedName("but_dum_id")
    @Expose
    private String butDumId;
    @SerializedName("but_alias")
    @Expose
    private String butAlias;

    @SuppressWarnings("unused")
    public String getButDumId() {
        return butDumId;
    }

    public void setButDumId(String butDumId) {
        this.butDumId = butDumId;
    }

    public String getButAlias() {
        return butAlias;
    }

    @SuppressWarnings("unused")
    public void setButAlias(String butAlias) {
        this.butAlias = butAlias;
    }

}
