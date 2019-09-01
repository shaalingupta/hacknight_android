package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.Map;

public class viewModel extends AndroidViewModel {
    private RetrofitClient retrofitClient;

    public viewModel(@NonNull Application application) {
        super(application);
        retrofitClient = RetrofitClient.getInstance(application);
    }

    public LiveData<Boolean> sendEmployeeRequest(Map<String, String> headers, EmployeeInfo e) {
        return retrofitClient.sendEmployeeRequest(headers,e);
    }
}
