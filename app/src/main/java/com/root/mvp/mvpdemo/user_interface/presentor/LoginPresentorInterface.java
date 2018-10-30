package com.root.mvp.mvpdemo.user_interface.presentor;

import android.view.View;

import java.util.HashMap;

public interface LoginPresentorInterface {
    void login(HashMap<String,String>hashMap, View view);
    void getData(String str, View view);
}
