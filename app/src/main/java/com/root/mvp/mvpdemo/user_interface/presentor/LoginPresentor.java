package com.root.mvp.mvpdemo.user_interface.presentor;

import android.content.Context;
import android.view.View;

import com.root.mvp.mvpdemo.R;
import com.root.mvp.mvpdemo.user_interface.model.LoginModel;
import com.root.mvp.mvpdemo.user_interface.pojoclass.LoginResponseBeans;
import com.root.mvp.mvpdemo.user_interface.view.LoginViewInterface;
import com.root.mvp.mvpdemo.utils.CheckInternetConnection;
import com.root.mvp.mvpdemo.utils.MessageUtils;

import java.util.HashMap;
import java.util.List;

public class LoginPresentor implements LoginModel.PostInterfaceCallback, LoginModel.GetDataInterfaceCallback, LoginPresentorInterface {
    private CheckInternetConnection checkInternetConnection;
    private Context mContext;
    private LoginModel loginModel;
    private LoginViewInterface loginViewInterface;

    public LoginPresentor(Context mContext, LoginViewInterface loginViewInterface) {
        this.mContext = mContext;
        this.loginViewInterface = loginViewInterface;
        this.checkInternetConnection = new CheckInternetConnection(this.mContext);
        loginModel = new LoginModel();
    }

    @Override
    public void onSuccessLoginView(List<LoginResponseBeans> loginResponseBeans) {
        if (loginViewInterface != null) {
            loginViewInterface.onSuccessLoginView(loginResponseBeans);
        }
    }

    @Override
    public void onErrorLoginView(String error) {
        if (loginViewInterface != null) {
            loginViewInterface.onErrorLoginView(error);
        }
    }

    @Override
    public void login(HashMap<String, String> hashMap, View view) {
        if (checkInternetConnection.isConnectingToInternet() && loginModel != null) {
            loginModel.login(hashMap, this);
        } else {
            new MessageUtils().snackbar(mContext.getString(R.string.internet), view);

        }
    }

    @Override
    public void getData(String str, View view) {
        if (checkInternetConnection.isConnectingToInternet() && loginModel != null) {
            loginModel.getData(str, this);
        } else {
            new MessageUtils().snackbar(mContext.getString(R.string.internet), view);

        }
    }
}
