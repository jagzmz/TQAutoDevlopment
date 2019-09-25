package com.turquoise.tqautom.Server.controller;

import android.content.Context;

import com.turquoise.tqautom.Server.model.IServerModel;
import com.turquoise.tqautom.Server.model.Result;
import com.turquoise.tqautom.Server.model.ServerModel;
import com.turquoise.tqautom.Server.view.IServerView;

public class ServerController implements IServerController {

    private final IServerView iServerView;
    private final IServerModel iServerModel;

    public ServerController(Context ctx,IServerView iServerView){
        this.iServerView=iServerView;
        iServerModel=new ServerModel(ctx);
    }


    @Override
    public void doFetchData() {

        Result result=iServerModel.getData();
        if(result!=null){
            saveData(result);
        }
        iServerView.onDataRecieved(result);

    }




    @Override
    public void saveData(Result result) {
        iServerModel.saveData(result);
    }
}
