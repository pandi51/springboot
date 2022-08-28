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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SSLConfig {
	
	String key = "C:\\Users\\CHELLAPANDI\\git\\springboot\\websocket-client\\src\\main\\resources\\keystore.p12";
	
	@Autowired
	Environment env;
	

	@Bean("wssFactory")
	public SSLSocketFactory createSSLConfigFactory() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyManagementException {
	    SSLSocketFactory factory = createSSLContext()
	        .getSocketFactory();
	    
	    return factory;
	}
	
	@Bean("wssSSLContext")
	public SSLContext createSSLContext() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyManagementException {
		String STORETYPE = "PKCS12";
	    
//	    key = env.getProperty("server.ssl.key-store");
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
	    
	 // Create a trust manager that does not validate certificate chains
//        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
//            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//            public void checkClientTrusted(X509Certificate[] certs, String authType) {
//            }
//            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//            }
//        }
//        };

	    SSLContext sslContext = null;
	    sslContext = SSLContext.getInstance("TLS");
	    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
//	    sslContext.init(kmf.getKeyManagers(), trustAllCerts, null);
	    
	    return sslContext;
	}
}
