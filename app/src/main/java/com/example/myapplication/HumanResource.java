package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HumanResource implements Serializable {

    @SerializedName("HrId")
    private String hrId;
    @SerializedName("HrName")
    private String hrName;
    @SerializedName("HrPassword")
    private String hrPassword;

    public HumanResource(String hrId, String hrName, String hrPassword) {
        this.hrId = hrId;
        this.hrName = hrName;
        this.hrPassword = hrPassword;
    }
}
