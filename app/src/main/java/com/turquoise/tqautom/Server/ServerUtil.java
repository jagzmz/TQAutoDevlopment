package com.turquoise.tqautom.Server;

import android.content.Context;

import com.turquoise.tqautom.Server.controller.ServerController;
import com.turquoise.tqautom.Server.model.Building;
import com.turquoise.tqautom.Server.view.IServerView;
import com.turquoise.tqautom.Utils.Notif;
import com.turquoise.tqautom.Server.model.Result;

import java.util.List;


public class ServerUtil implements IServerView {

    private final ServerController serverController;
    private final Context ctx;


    public ServerUtil(Context ctx){
        this.ctx=ctx;
        serverController=new ServerController(ctx,ServerUtil.this);
    }

    public void getData(){
        serverController.doFetchData();
    }


    @Override
    public void onDataRecieved(Result result) {
        if(result==null){
            Notif.showToast(ctx,"Result is Null");
        }
        else{
            List<Building> buildings=result.getCustomer().getBuildings();
            StringBuilder name= new StringBuilder();
            for(Building b:buildings){
                name.append(b.getName()).append("\n");
            }
            Notif.showToast(ctx, name.toString());
        }
    }
}
