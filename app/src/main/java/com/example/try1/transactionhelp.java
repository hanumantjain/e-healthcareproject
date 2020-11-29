package com.example.try1;

public class transactionhelp {

    public transactionhelp(String doctorf, String labf, String misf, String treatf, String totalfee) {
        this.doctorf = doctorf;
        this.labf = labf;
        this.misf = misf;
        this.treatf = treatf;
        this.totalfee = totalfee;
    }

    public String getDoctorf() {
        return doctorf;
    }

    public void setDoctorf(String doctorf) {
        this.doctorf = doctorf;
    }

    public String getLabf() {
        return labf;
    }

    public void setLabf(String labf) {
        this.labf = labf;
    }

    public String getMisf() {
        return misf;
    }

    public void setMisf(String misf) {
        this.misf = misf;
    }

    public String getTreatf() {
        return treatf;
    }

    public void setTreatf(String treatf) {
        this.treatf = treatf;
    }

    public String getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(String totalfee) {
        this.totalfee = totalfee;
    }

    String doctorf;
    String labf;
    String misf;
    String treatf;
    String totalfee;

    public transactionhelp(){

    }
}
