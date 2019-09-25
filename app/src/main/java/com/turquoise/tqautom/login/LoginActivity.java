package com.turquoise.tqautom.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.turquoise.tqautom.MainActivity;
import com.turquoise.tqautom.R;
import com.turquoise.tqautom.Utils.Notif;
import com.turquoise.tqautom.login.controller.LoginController;
import com.turquoise.tqautom.login.model.Result;
import com.turquoise.tqautom.login.view.ILoginView;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private TextInputEditText user;
    private TextInputEditText pass;
    private LoginController loginController;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginController = new LoginController(this, this);

        if (loginController.sessionExists()) {

            Notif.showToast(getApplicationContext(),"Launching Main Activity");
            Intent i= new Intent(LoginActivity.this,MainActivity.class);

            startActivity(i);
            finish();

        } else {
            Button loginClick = this.findViewById(R.id.loginBtn);
            loginClick.setOnClickListener(this);
            user = findViewById(R.id.username);
            pass = findViewById(R.id.password);
        }

    }


    @Override
    public void onLoginResult(Result result) {
        if (result != null && progressDialog != null) {
            loginController.setProgressBarVisibility(View.INVISIBLE);
//            Toast.makeText(this, String.valueOf(result.getAuth().getSessId()), Toast.LENGTH_LONG).show();
            loginController.setSession(result);
            Intent i= new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        if (visibility == View.VISIBLE) {
            progressDialog = ProgressDialog.show(this, "", "check", true, false);
        } else {

            if (progressDialog != null)
                progressDialog.dismiss();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.loginBtn) {
            loginController.setProgressBarVisibility(View.VISIBLE);
            loginController.doLogin(Objects.requireNonNull(user.getText()).toString(), Objects.requireNonNull(pass.getText()).toString());
        }
    }


}
