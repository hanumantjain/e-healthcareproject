package com.example.try1;

public class UserHelperClass1 {
    String docname;
    String docusername;
    String docphoneno;
    String docpassword;
    String docemail;

    public UserHelperClass1() {
    }

    public UserHelperClass1(String docname, String docusername, String docphoneno,String docpassword, String docemail) {
        this.docname = docname;
        this.docusername = docusername;
        this.docphoneno = docphoneno;
        this.docemail = docemail;
        this.docpassword= docpassword;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocusername() {
        return docusername;
    }

    public void setDocusername(String docusername) {
        this.docusername = docusername;
    }

    public String getDocphoneno() {
        return docphoneno;
    }

    public void setDocphoneno(String docphoneno) {
        this.docphoneno = docphoneno;
    }

    public String getDocemail() {
        return docemail;
    }

    public void setDocemail(String docemail) {
        this.docemail = docemail;
    }

    public String getDocpassword() {
        return docpassword;
    }

    public void setDocpassword(String docpassword) {
        this.docpassword = docpassword;
    }


}


