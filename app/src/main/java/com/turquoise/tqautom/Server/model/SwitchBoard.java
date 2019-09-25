
package com.turquoise.tqautom.Server.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SwitchBoard {

    @SerializedName("sw_dum_id")
    @Expose
    private String swDumId;
    @SerializedName("buttons")
    @Expose
    private List<Button> buttons = null;

    public String getSwDumId() {
        return swDumId;
    }

    @SuppressWarnings("unused")
    public void setSwDumId(String swDumId) {
        this.swDumId = swDumId;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

}
