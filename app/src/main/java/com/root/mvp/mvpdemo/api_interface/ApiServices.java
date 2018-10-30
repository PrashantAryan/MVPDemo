package com.root.mvp.mvpdemo.api_interface;

import com.root.mvp.mvpdemo.user_interface.pojoclass.LoginResponseBeans;
import com.root.mvp.mvpdemo.utils.ApplicationConstant;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {

    @POST(ApplicationConstant.LOGIN)
    Call<List<LoginResponseBeans>> LOGIN_RESPONSE_BEANS_CALL(@Body HashMap<String, String> loginHashMap);

    @POST(ApplicationConstant.DASHBOARD)
    Call<List<LoginResponseBeans>> GET_DATA_RESPONSE_BEANS_CALL(@Body String loginHashMap);


}
