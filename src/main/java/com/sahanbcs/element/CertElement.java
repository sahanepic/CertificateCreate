package com.sahanbcs.element;

public class CertElement {

    private int keySize;

    private String issureName;
    private String issuer_organizationUnit;
    private String issuer_organizationName;
    private String  issuer_country;
    private String  issuer_localityName;
    private String  issuer_email;


    private String subjectName;
    private String subject_organizationUnit;
    private String subject_organizationName;
    private String  subject_country;
    private String  subject_localityName;
    private String  subject_email;

    private  int noOfDatetobeExpired;
    private String filename ;




    private String filesevedLocation ="C:\\Users\\sahan_k\\Desktop\\sahan_k\\sahan-Crpto\\SahanCrypto\\certificates\\cert\\" ;

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public String getIssureName() {
        return issureName;
    }

    public void setIssureName(String issureName) {
        this.issureName = issureName;
    }

    public String getIssuer_organizationUnit() {
        return issuer_organizationUnit;
    }

    public void setIssuer_organizationUnit(String issuer_organizationUnit) {
        this.issuer_organizationUnit = issuer_organizationUnit;
    }

    public String getIssuer_organizationName() {
        return issuer_organizationName;
    }

    public void setIssuer_organizationName(String issuer_organizationName) {
        this.issuer_organizationName = issuer_organizationName;
    }

    public String getIssuer_country() {
        return issuer_country;
    }

    public void setIssuer_country(String issuer_country) {
        this.issuer_country = issuer_country;
    }

    public String getIssuer_localityName() {
        return issuer_localityName;
    }

    public void setIssuer_localityName(String issuer_localityName) {
        this.issuer_localityName = issuer_localityName;
    }

    public String getIssuer_email() {
        return issuer_email;
    }

    public void setIssuer_email(String issuer_email) {
        this.issuer_email = issuer_email;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubject_organizationUnit() {
        return subject_organizationUnit;
    }

    public void setSubject_organizationUnit(String subject_organizationUnit) {
        this.subject_organizationUnit = subject_organizationUnit;
    }

    public String getSubject_organizationName() {
        return subject_organizationName;
    }

    public void setSubject_organizationName(String subject_organizationName) {
        this.subject_organizationName = subject_organizationName;
    }

    public String getSubject_country() {
        return subject_country;
    }

    public void setSubject_country(String subject_country) {
        this.subject_country = subject_country;
    }

    public String getSubject_localityName() {
        return subject_localityName;
    }

    public void setSubject_localityName(String subject_localityName) {
        this.subject_localityName = subject_localityName;
    }

    public String getSubject_email() {
        return subject_email;
    }

    public void setSubject_email(String subject_email) {
        this.subject_email = subject_email;
    }

    public int getNoOfDatetobeExpired() {
        return noOfDatetobeExpired;
    }

    public void setNoOfDatetobeExpired(int noOfDatetobeExpired) {
        this.noOfDatetobeExpired = noOfDatetobeExpired;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilesevedLocation() {
        return filesevedLocation;
    }
}
