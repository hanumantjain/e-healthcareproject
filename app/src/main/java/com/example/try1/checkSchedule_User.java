package com.example.try1;



public class checkSchedule_User {

    private String PatientName;
    public checkSchedule_User(String patientName){
        this.PatientName=patientName;
    }
    public String getUsername(){
        return PatientName;
    }
    public void setPatientName(String patientName) {
        this.PatientName = patientName;
    }

}
