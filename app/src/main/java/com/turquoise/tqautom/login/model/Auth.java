package com.turquoise.tqautom.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("ALL")
public class Auth {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("sessId")
    @Expose
    private String sessId;
    @SerializedName("cusId")
    @Expose
    private String cusId;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getSessId() {
        return sessId;
    }

    public void setSessId(String sessId) {
        this.sessId = sessId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
}