package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String tag = RetrofitClient.class.getName();

    private static RetrofitClient instance;
    private APIService apiService;
    private Context context;
    private static final String BASE_URL = "https://mindfox.azurewebsites.net";

    private RetrofitClient(Context context) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        apiService = retrofit.create(APIService.class);
        this.context = context;

    }

    public synchronized static RetrofitClient getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitClient(context);

        }
        return instance;
    }


    public LiveData<Boolean> sendEmployeeRequest(Map<String,String>headers,EmployeeInfo employeeInfo) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();

        apiService.sendEmployeeRequest(headers,employeeInfo).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    data.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                data.setValue(false);
                Log.i(tag,t.getMessage()+" "+t.getCause());
            }
        });
        return data;
    }
}
