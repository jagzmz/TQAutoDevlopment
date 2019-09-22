package com.turquoise.tqautom.login.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.turquoise.tqautom.login.model.IUser;
import com.turquoise.tqautom.login.model.Result;
import com.turquoise.tqautom.login.model.UserModel;
import com.turquoise.tqautom.login.view.ILoginView;

import java.util.logging.Handler;


public class LoginController implements ILoginController {

    private final Context ctx;
    private final ILoginView iLoginView;
    private IUser user;
    Handler handler;
    final private String USER_SESS_ID = "USER_SESS";

    public LoginController(Context context, ILoginView iLoginView) {
        ctx = context;
        this.iLoginView = iLoginView;
        initUser();
    }

    @Override
    public void doLogin(String username, String pass) {
        String TAG = "doLogin";
        Log.d(TAG, "Doing Login");

        Result result = user.checkExists(ctx, username, pass);
        iLoginView.onLoginResult(result);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    @Override
    public boolean sessionExists() {
        SharedPreferences isSes = ctx.getSharedPreferences(USER_SESS_ID, Context.MODE_PRIVATE);
        return isSes.contains(USER_SESS_ID);
    }

    @Override
    public void setSession(Result result) {
        SharedPreferences.Editor sesEdit = ctx.getSharedPreferences(USER_SESS_ID, Context.MODE_PRIVATE).edit();

        sesEdit.putString(USER_SESS_ID,toJson(result));
        sesEdit.apply();
    }

    private String toJson(Result result){
        Gson gson=new Gson();
        return gson.toJson(result);
    }

    @Override
    public void terminateSession() {
        SharedPreferences.Editor sesEdit = ctx.getSharedPreferences(USER_SESS_ID, Context.MODE_PRIVATE).edit();
        sesEdit.clear();
        sesEdit.apply();
    }


    private void initUser() {
        user = new UserModel("", "");

    }
}
