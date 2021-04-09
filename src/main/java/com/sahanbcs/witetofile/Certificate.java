package com.sahanbcs.witetofile;

import com.sahanbcs.element.CertElement;
import com.sahanbcs.utills.Printer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Certificate {

    private  Certificate(){

    }

    public static final String BEGIN_CERT = "-----BEGIN CERTIFICATE-----";
    public static final String END_CERT = "-----END CERTIFICATE-----";
    public final static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static  void writeToFile(X509Certificate cert, CertElement certel) throws IOException, CertificateEncodingException {

        final Base64.Encoder encoder = Base64.getMimeEncoder(64, LINE_SEPARATOR.getBytes());

        final byte[] rawCrtText = cert.getEncoded();

        final String encodedCertText = new String(encoder.encode(rawCrtText));
        final String prettified_cert = BEGIN_CERT + LINE_SEPARATOR + encodedCertText + LINE_SEPARATOR + END_CERT;
        OutputStreamWriter out = null;

        try {
              out = new OutputStreamWriter(new FileOutputStream( certel.getFilesevedLocation() + certel.getFilename() +".cer" ));
            out.write(prettified_cert);
            out.flush();
        }catch (FileNotFoundException ee ){
            ee.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(out != null)
                out.close();
        }


        Printer.print("Finalaized");
    }

}
