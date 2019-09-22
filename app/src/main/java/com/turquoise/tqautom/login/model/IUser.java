package com.turquoise.tqautom.login.model;

import android.content.Context;

public interface IUser {
    @SuppressWarnings("unused")
    String getUser();
    @SuppressWarnings("unused")
    String getCusId();
    String getPass();
    @SuppressWarnings("unused")
    void setCusId(String cusId);
    @SuppressWarnings("unused")
    Result checkExists(Context ctx, String user, String pass);
}
