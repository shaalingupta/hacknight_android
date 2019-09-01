package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

class EmployeeInfo extends Employee {

    private String remote_work;
    @SerializedName("work_interfere")
    private String work_interfere;
    @SerializedName("family_history")
    private String family_history;
    @SerializedName("wellness_program")
    private String wellness_program;
    @SerializedName("seek_help")
    private String seek_help;
    @SerializedName("mental_health_consequence")
    private String mental_health_consequence;
    @SerializedName("phys_health_consequence")
    private String phys_health_consequence;
    @SerializedName("supervisor")
    private String supervisor;
    @SerializedName("mental_health_interview")
    private String mental_health_interview;
    @SerializedName("phys_health_interview")
    private String phys_health_interview;
    @SerializedName("obs_consequence")
    private String obs_consequence;
    @SerializedName("comments")
    private String comments;

    public EmployeeInfo(String noOfEmp, String techCompany, String benefits, String care_options, String leave_Options, String empId, String empName, String empAge, String empCountry, String empGender, String empState, String remote_work, String work_interfere, String family_history, String wellness_program, String seek_help, String mental_health_consequence, String phys_health_consequence, String supervisor, String mental_health_interview, String phys_health_interview, String obs_consequence, String comments) {
        super(noOfEmp, techCompany, benefits, care_options, leave_Options, empId, empName, empAge, empCountry, empGender, empState);
        this.remote_work = remote_work;
        this.work_interfere = work_interfere;
        this.family_history = family_history;
        this.wellness_program = wellness_program;
        this.seek_help = seek_help;
        this.mental_health_consequence = mental_health_consequence;
        this.phys_health_consequence = phys_health_consequence;
        this.supervisor = supervisor;
        this.mental_health_interview = mental_health_interview;
        this.phys_health_interview = phys_health_interview;
        this.obs_consequence = obs_consequence;
        this.comments = comments;
    }

    public String getRemote_work() {
        return remote_work;
    }

    public void setRemote_work(String remote_work) {
        this.remote_work = remote_work;
    }

    public String getWork_interfere() {
        return work_interfere;
    }

    public void setWork_interfere(String work_interfere) {
        this.work_interfere = work_interfere;
    }

    public String getFamily_history() {
        return family_history;
    }

    public void setFamily_history(String family_history) {
        this.family_history = family_history;
    }

    public String getWellness_program() {
        return wellness_program;
    }

    public void setWellness_program(String wellness_program) {
        this.wellness_program = wellness_program;
    }

    public String getSeek_help() {
        return seek_help;
    }

    public void setSeek_help(String seek_help) {
        this.seek_help = seek_help;
    }

    public String getMental_health_consequence() {
        return mental_health_consequence;
    }

    public void setMental_health_consequence(String mental_health_consequence) {
        this.mental_health_consequence = mental_health_consequence;
    }

    public String getPhys_health_consequence() {
        return phys_health_consequence;
    }

    public void setPhys_health_consequence(String phys_health_consequence) {
        this.phys_health_consequence = phys_health_consequence;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getMental_health_interview() {
        return mental_health_interview;
    }

    public void setMental_health_interview(String mental_health_interview) {
        this.mental_health_interview = mental_health_interview;
    }

    public String getPhys_health_interview() {
        return phys_health_interview;
    }

    public void setPhys_health_interview(String phys_health_interview) {
        this.phys_health_interview = phys_health_interview;
    }

    public String getObs_consequence() {
        return obs_consequence;
    }

    public void setObs_consequence(String obs_consequence) {
        this.obs_consequence = obs_consequence;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
