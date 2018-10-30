package com.root.mvp.mvpdemo.user_interface.view;

import com.root.mvp.mvpdemo.user_interface.pojoclass.LoginResponseBeans;

import java.util.List;

public interface LoginViewInterface {

    void onSuccessLoginView(List<LoginResponseBeans> loginResponseBeans);

    void onErrorLoginView(String error);
}
