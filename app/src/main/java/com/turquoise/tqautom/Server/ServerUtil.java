package com.turquoise.tqautom.Server;

import android.content.Context;
import android.util.Log;

import com.turquoise.tqautom.Server.controller.ServerController;
import com.turquoise.tqautom.Server.model.Building;
import com.turquoise.tqautom.Server.view.IServerView;
import com.turquoise.tqautom.Utils.Notif;
import com.turquoise.tqautom.Server.model.Result;

import java.util.List;


public class ServerUtil implements IServerView {

    private final ServerController serverController;
    private final Context ctx;
    private Result result;

    public ServerUtil(Context ctx){
        this.ctx=ctx;
        serverController=new ServerController(ctx,ServerUtil.this);
    }

    public void getData(){
        serverController.doFetchData();

    }

    public List<Building> getBuildings(){
        return result.getCustomer().getBuildings();
    }


    @Override
    public void onDataRecieved(Result result) {
        if(result==null){
            Notif.showToast(ctx,"Result is Null");
        }
        else{
            Log.d("ServerUtil", "onDataRecieved: "+result.getCustomer().getBuildings());
            this.result=result;
        }
    }



}
