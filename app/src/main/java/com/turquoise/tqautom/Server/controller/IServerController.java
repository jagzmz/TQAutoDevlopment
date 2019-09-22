package com.turquoise.tqautom.Server.controller;

import com.turquoise.tqautom.Server.model.Result;

interface IServerController {

    @SuppressWarnings("unused")
    void doFetchData();
    void saveData(Result result);

}
