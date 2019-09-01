package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("no_employees")
    private String noOfEmp;
    @SerializedName("tech_company")
    private String techCompany;
    @SerializedName("benefits")
    private String benefits;
    @SerializedName("care_options")
    private String care_options;
    @SerializedName("leave")
    private String leave_Options;

    public Company(String noOfEmp, String techCompany, String benefits, String care_options, String leave_Options) {
        this.noOfEmp = noOfEmp;
        this.techCompany = techCompany;
        this.benefits = benefits;
        this.care_options = care_options;
        this.leave_Options = leave_Options;
    }

    public String getNoOfEmp() {
        return noOfEmp;
    }

    public void setNoOfEmp(String noOfEmp) {
        this.noOfEmp = noOfEmp;
    }

    public String getTechCompany() {
        return techCompany;
    }

    public void setTechCompany(String techCompany) {
        this.techCompany = techCompany;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getCare_options() {
        return care_options;
    }

    public void setCare_options(String care_options) {
        this.care_options = care_options;
    }

    public String getLeave_Options() {
        return leave_Options;
    }

    public void setLeave_Options(String leave_Options) {
        this.leave_Options = leave_Options;
    }
}
