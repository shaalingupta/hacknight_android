package com.example.myapplication;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface APIService {

    @POST("/api/getEmpData")
    Call<ResponseBody> sendEmployeeRequest(@HeaderMap Map<String,String> headers, @Body EmployeeInfo post);
}
