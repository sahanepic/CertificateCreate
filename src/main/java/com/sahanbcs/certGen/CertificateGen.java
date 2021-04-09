package com.sahanbcs.certGen;

import com.sahanbcs.element.CertElement;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;


import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CertificateGen {

    CertElement certElement = null;


    public CertificateGen(CertElement ce) {
        this.certElement = ce;
    }

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
        keyPairGenerator.initialize(certElement.getKeySize() , new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        X509V3CertificateGenerator   cerGern = new X509V3CertificateGenerator();
        String dirNameIssure ="" +
                "CN=" + certElement.getIssureName() +
                ",OU=" + certElement.getIssuer_organizationUnit() +
                ",O=" +certElement.getIssuer_organizationName() +
                ",L="+certElement.getIssuer_localityName()+
                " ,c="+certElement.getSubject_country()+"";
        X509Principal dnName = new X509Principal(dirNameIssure);
        cerGern.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
        String dirNameSubject ="" +
                "dc="+certElement.getSubjectName()+
                ",ou="+certElement.getIssuer_organizationUnit()+
                ",o="+certElement.getSubject_organizationName()+
                ",l="+certElement.getSubject_localityName()+
                ",c="+certElement.getSubject_country() +"";
        cerGern.setSubjectDN(new X509Principal(dirNameSubject));
        cerGern.setIssuerDN(dnName);
        cerGern.setNotBefore(new Date(System.currentTimeMillis()  ));

        cerGern.setNotAfter(new Date((System.currentTimeMillis() + 24*60*60*1000*certElement.getNoOfDatetobeExpired())));
        cerGern.setPublicKey(keyPair.getPublic());
        cerGern.setSignatureAlgorithm("SHA256WithRSAEncryption");
        cerGern.addExtension(X509Extensions.ExtendedKeyUsage , true,new ExtendedKeyUsage(KeyPurposeId.id_kp_timeStamping ));

    X509Certificate cert =cerGern.generate(keyPair.getPrivate());

        return cert;

    }
}
