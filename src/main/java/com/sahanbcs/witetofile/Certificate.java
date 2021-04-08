package com.sahanbcs.witetofile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Certificate {

    public static final String BEGIN_CERT = "-----BEGIN CERTIFICATE-----";
    public static final String END_CERT = "-----END CERTIFICATE-----";
    public final static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static  void writeToFile(X509Certificate cert) throws IOException, CertificateEncodingException {

        final Base64.Encoder encoder = Base64.getMimeEncoder(64, LINE_SEPARATOR.getBytes());

        final byte[] rawCrtText = cert.getEncoded();

        final String encodedCertText = new String(encoder.encode(rawCrtText));
        final String prettified_cert = BEGIN_CERT + LINE_SEPARATOR + encodedCertText + LINE_SEPARATOR + END_CERT;


        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("Sahan.cer"));
        out.write(prettified_cert);
        out.flush();

        out.close();
        System.out.println("Finalaized");
    }

}
