package com.turquoise.tqautom.login.controller;

import com.turquoise.tqautom.login.model.Result;

interface ILoginController {


    @SuppressWarnings("unused")
    void doLogin(String user, String pass);
    @SuppressWarnings("unused")
    void setProgressBarVisibility(int visibility);
    @SuppressWarnings("unused")
    boolean sessionExists();
    @SuppressWarnings("unused")
    void setSession(Result result);
    @SuppressWarnings("unused")
    void terminateSession();

}
