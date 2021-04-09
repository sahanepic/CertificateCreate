package com.sahanbcs.main;

import com.sahanbcs.certGen.CertificateGen;
import com.sahanbcs.certinputs.CertInputs;
import com.sahanbcs.element.CertElement;
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

        CertElement ce = new CertElement();

        CertInputs.getCertificateInputDetails(ce);




        CertificateGen cc = new CertificateGen(ce);
        X509Certificate cert = null;
        try {
            cert = cc.generateSelfSignedX509Certificate();
        }catch (Exception e){
            e.printStackTrace();
        }

        Printer.outln("The Certificate is : \n");
        if(cert != null){
            Printer.outln(cert.toString());
            Certificate.writeToFile(cert,ce);
        }

        Printer.print("The Finaly Certificate is Saved on location :\n\n \t\t"  + ce.getFilesevedLocation() +ce.getFilename() );

    }
}
