package com.example.try1;

public class UserHelperClass {
    String patientname;
    String username;
    String phoneno;
    String email;
    String password;
    String dob;
    String sex;

    public UserHelperClass() {

    }


    public UserHelperClass(String patientname, String username, String password, String phoneno, String email, String dob, String sex) {
        this.patientname = patientname;
        this.username = username;
        this.phoneno = phoneno;
        this.email = email;
        this.password =password;
        this.dob = dob;
        this.sex = sex;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordP) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
