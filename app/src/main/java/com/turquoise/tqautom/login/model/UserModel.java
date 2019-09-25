package com.turquoise.tqautom.login.model;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserModel implements IUser {

    private final String user;
    private String cusId;
    private final String pass;

    public UserModel(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getCusId() {
        return cusId;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }


    @Override
    public Result checkExists(Context ctx, String user, String pass) {

        Gson gson= new Gson();
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(ctx.getAssets().open("mockUser.json")));
            Result result=gson.fromJson(br,Result.class);
            if(result.getAuth().getSuccess()){
                return result;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
