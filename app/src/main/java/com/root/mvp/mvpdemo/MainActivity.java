package com.root.mvp.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.root.mvp.mvpdemo.user_interface.pojoclass.LoginResponseBeans;
import com.root.mvp.mvpdemo.user_interface.presentor.LoginPresentor;
import com.root.mvp.mvpdemo.user_interface.presentor.LoginPresentorInterface;
import com.root.mvp.mvpdemo.user_interface.view.LoginViewInterface;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoginViewInterface {
    private HashMap<String, String> stringStringHashMap = new HashMap<>();
    private LoginPresentorInterface loginPresentorInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*call this method connect to web services*/
    public void callRemoteDataforPost() {
        stringStringHashMap.put("email", "email");
        stringStringHashMap.put("password", "password");
        loginPresentorInterface = new LoginPresentor(this, this);
        loginPresentorInterface.login(stringStringHashMap, new View(this));
    }
    /*call this method connect to web services*/
    public void callRemoteDataforGet() {
         loginPresentorInterface = new LoginPresentor(this, this);
        loginPresentorInterface.getData("", new View(this));
    }

    @Override
    public void onSuccessLoginView(List<LoginResponseBeans> loginResponseBeans) {

    }

    @Override
    public void onErrorLoginView(String error) {

    }
}
