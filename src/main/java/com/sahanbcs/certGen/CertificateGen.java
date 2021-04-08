package com.sahanbcs.certGen;

import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import javax.security.auth.x500.X500Principal;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CertificateGen {


    public void  addSecutityPrvide() {
        Security.addProvider(new BouncyCastleProvider());
    }

    public X509Certificate generateSelfSignedX509Certificate() throws
            NoSuchAlgorithmException,
            NoSuchProviderException,
            CertificateEncodingException,
            SignatureException,
            InvalidKeyException {



        addSecutityPrvide();

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA","BC");
        keyPairGenerator.initialize(2048 , new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        X509V3CertificateGenerator   cerGern = new X509V3CertificateGenerator();
        X500Principal dnName = new X500Principal("cn=Sahanbcs");
        cerGern.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
        cerGern.setSubjectDN(new X509Name("dc=sahanuor"));
        cerGern.setIssuerDN(dnName);
        cerGern.setNotBefore(new Date(System.currentTimeMillis()  ));

        cerGern.setNotAfter(new Date((System.currentTimeMillis() + 24*60*60*1000)));
        cerGern.setPublicKey(keyPair.getPublic());
        cerGern.setSignatureAlgorithm("SHA256WithRSAEncryption");
        cerGern.addExtension(X509Extensions.ExtendedKeyUsage , true,new ExtendedKeyUsage(KeyPurposeId.id_kp_timeStamping ));

    X509Certificate cert =cerGern.generate(keyPair.getPrivate());

        return cert;

    }
}
