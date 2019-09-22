package com.turquoise.tqautom.Server.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.turquoise.tqautom.R;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerModel implements IServerModel {

    private final Context ctx;
    private static String USER_SESS;

    public ServerModel(Context ctx){
        this.ctx=ctx;
        USER_SESS=ctx.getString(R.string.SP_USER);
        
    }

    @Override
    public Result getData() {

        SharedPreferences sp= ctx.getSharedPreferences(ctx.getString(R.string.SP_USER),Context.MODE_PRIVATE);

        if(sp.contains(ctx.getString(R.string.SP_USER_DATA))){
            return getJson(sp.getString(ctx.getString(R.string.SP_USER_DATA),""));
        }

        Gson gson= new Gson();
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(ctx.getAssets().open("userData.json")));
            return gson.fromJson(br, Result.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Result getJson(String res){
        Gson gson=new Gson();

        return gson.fromJson(res,Result.class);
    }

    @Override
    public void saveData(Result result) {
        Gson gson= new Gson();
        String data=gson.toJson(result);
        SharedPreferences.Editor spe= ctx.getSharedPreferences(USER_SESS,Context.MODE_PRIVATE).edit();
        spe.putString(ctx.getString(R.string.SP_USER_DATA),data);
        spe.apply();
    }
}
