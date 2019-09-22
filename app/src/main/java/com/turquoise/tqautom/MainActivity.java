package com.turquoise.tqautom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.turquoise.tqautom.Server.ServerUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServerUtil serverUtil= new ServerUtil(MainActivity.this);
        serverUtil.getData();


    }



}
