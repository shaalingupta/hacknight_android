package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Employee extends Company implements Serializable {

    @SerializedName("id")
    private String empId;
    @SerializedName("name")
    private String empName;
    @SerializedName("Age")
    private String empAge;
    @SerializedName("Country")
    private String empCountry;
    @SerializedName("Gender")
    private String empGender;
    @SerializedName("state")
    private String empState;

    public Employee(String noOfEmp, String techCompany, String benefits, String care_options, String leave_Options, String empId, String empName, String empAge, String empCountry, String empGender, String empState) {
        super(noOfEmp, techCompany, benefits, care_options, leave_Options);
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empCountry = empCountry;
        this.empGender = empGender;
        this.empState = empState;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAge() {
        return empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public String getEmpCountry() {
        return empCountry;
    }

    public void setEmpCountry(String empCountry) {
        this.empCountry = empCountry;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpState() {
        return empState;
    }

    public void setEmpState(String empState) {
        this.empState = empState;
    }
}
