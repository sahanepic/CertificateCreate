package com.sahanbcs.certinputs;

import com.sahanbcs.element.CertElement;
import com.sahanbcs.utills.Printer;

import java.util.Scanner;

public class CertInputs {


    public static void getCertificateInputDetails(CertElement cert){

        Scanner sc = new Scanner(System.in);
        Printer.out("\t\tEnter Here Certificate Informatoin\n\n");
        Printer.out("Enter the Key Size (1024,2048,4096) :");

        cert.setKeySize(Integer.parseInt(sc.nextLine()));
        Printer.out("\n\t\tIssure Details\n");

        Printer.out("Name \t:");
        cert.setIssureName(sc.nextLine().trim());
        Printer.out("Organization Unit\t:");
        cert.setIssuer_organizationUnit(sc.nextLine().trim());
        Printer.out("Organization  \t:");
        cert.setIssuer_organizationName(sc.nextLine().trim());
        Printer.out("Country (2 Letters) [US] \t:");
        cert.setIssuer_country(sc.nextLine().trim());
        Printer.out("Locality Name\t:");
        cert.setIssuer_localityName (sc.nextLine().trim());
        Printer.out("Email \t:");
        cert.setIssuer_email (sc.nextLine().trim());

        Printer.out("\n\t\tSubject  Details\n");

        Printer.out("Name \t:");
        cert.setSubjectName(sc.nextLine().trim());
        Printer.out("Organization Unit\t:");
        cert.setSubject_organizationUnit(sc.nextLine().trim());
        Printer.out("Organization  \t:");
        cert.setSubject_organizationName(sc.nextLine().trim());
        Printer.out("Country Unit\t:");
        cert.setSubject_country(sc.nextLine().trim());
        Printer.out("Locality Name\t:");
        cert.setSubject_localityName(sc.nextLine().trim());
        Printer.out("Email \t:");
        cert.setSubject_email(sc.nextLine().trim());


        Printer.outln(" \n\n\n Enter No of Days to be valid :");
        cert.setNoOfDatetobeExpired(Integer.parseInt(sc.nextLine().trim()));

        Printer.outln(" \n\n\n Enter cert File name Should be saved As :");
        cert.setFilename((sc.nextLine().trim()));
    }



}
