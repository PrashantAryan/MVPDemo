package com.root.mvp.mvpdemo.user_interface.model;

import com.root.mvp.mvpdemo.api_interface.ApiServices;
import com.root.mvp.mvpdemo.api_interface.RetrofitClass;
import com.root.mvp.mvpdemo.user_interface.pojoclass.LoginResponseBeans;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

interface LoginInterface {
    interface PostInterfaceCallback {
        void onSuccessLoginView(List<LoginResponseBeans> loginResponseBeans);

        void onErrorLoginView(String error);

    }

    interface GetDataInterfaceCallback {
        void onSuccessLoginView(List<LoginResponseBeans> loginResponseBeans);

        void onErrorLoginView(String error);

    }


    void login(HashMap<String, String> loginHashmap, PostInterfaceCallback loginInterfaceCallback);

    void getData(String loginHashmap, GetDataInterfaceCallback loginInterfaceCallback);
}

public class LoginModel implements LoginInterface {
    @Override
    public void login(HashMap<String, String> loginHashmap, final PostInterfaceCallback loginInterfaceCallback) {
        ApiServices apiServices = RetrofitClass.retrofit.create(ApiServices.class);
        Call<List<LoginResponseBeans>> listCall = apiServices.LOGIN_RESPONSE_BEANS_CALL(loginHashmap);
        listCall.enqueue(new Callback<List<LoginResponseBeans>>() {
            @Override
            public void onResponse(Call<List<LoginResponseBeans>> call, Response<List<LoginResponseBeans>> response) {
                if (response.isSuccessful()) {
                    loginInterfaceCallback.onSuccessLoginView(response.body());
                } else {
                    loginInterfaceCallback.onErrorLoginView(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<LoginResponseBeans>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getData(String loginHashmap, final GetDataInterfaceCallback loginInterfaceCallback) {
        ApiServices apiServices = RetrofitClass.retrofit.create(ApiServices.class);
        Call<List<LoginResponseBeans>> listCall = apiServices.GET_DATA_RESPONSE_BEANS_CALL(loginHashmap);
        listCall.enqueue(new Callback<List<LoginResponseBeans>>() {
            @Override
            public void onResponse(Call<List<LoginResponseBeans>> call, Response<List<LoginResponseBeans>> response) {
                if (response.isSuccessful()) {
                    loginInterfaceCallback.onSuccessLoginView(response.body());
                } else {
                    loginInterfaceCallback.onErrorLoginView(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<LoginResponseBeans>> call, Throwable t) {

            }
        });
    }
}
