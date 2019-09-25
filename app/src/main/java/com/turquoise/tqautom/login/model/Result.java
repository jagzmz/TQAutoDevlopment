package com.turquoise.tqautom.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("auth")
    @Expose
    private Auth auth;

    public Auth getAuth() {
        return auth;
    }

    @SuppressWarnings("unused")
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

}