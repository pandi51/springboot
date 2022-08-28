package com.springboot.websocketclient.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSLConfig {
	

	@Bean("wssFactory")
	public SSLSocketFactory createSSLConfigFactory() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyManagementException {
		String STORETYPE = "PKCS12";
	    String key = "C:\\Users\\CHELLAPANDI\\git\\Java-WebSocket\\src\\main\\example\\keystore.p12";
	    String KEYSTORE = Paths.get(key).toString();
	    String STOREPASSWORD = "test123";
	    String KEYPASSWORD = "test123";

	    KeyStore ks = KeyStore.getInstance(STORETYPE);
	    File kf = new File(KEYSTORE);
	    ks.load(new FileInputStream(kf), STOREPASSWORD.toCharArray());

	    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	    kmf.init(ks, KEYPASSWORD.toCharArray());
	    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
	    tmf.init(ks);

	    SSLContext sslContext = null;
	    sslContext = SSLContext.getInstance("TLS");
	    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

	    SSLSocketFactory factory = sslContext
	        .getSocketFactory();
	    
	    return factory;
	}
}
