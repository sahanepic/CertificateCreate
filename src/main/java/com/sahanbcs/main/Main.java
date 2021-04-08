package com.sahanbcs.main;

import com.sahanbcs.certGen.CertificateGen;
import com.sahanbcs.utills.Printer;
import com.sahanbcs.witetofile.Certificate;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

public class Main {

    public static void main(String[] args) throws IOException, CertificateEncodingException {

        CertificateGen cc = new CertificateGen();
        X509Certificate cert = null;
        try {
            cert = cc.generateSelfSignedX509Certificate();
        }catch (Exception e){
            e.printStackTrace();
        }

        Printer.print("The Certificate is : \n");
        if(cert != null){
            Printer.print(cert.toString());
            Certificate.writeToFile(cert);
        }

    }
}
