package com.turquoise.tqautom.login.view;

import com.turquoise.tqautom.login.model.Result;

public interface ILoginView {

    void onLoginResult(Result result);
    void onSetProgressBarVisibility(int visibility);
}
