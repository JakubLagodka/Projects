package it.unipol.crm.attivita.batch.stsclient.configuration;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * code taken from: https://github.com/OpenFeign/feign/issues/525
 */

public class SSLSocketClient {

    //SSLSocketFactory
    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            var sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, getTrustManager(), new SecureRandom());
            return sslContext.getSocketFactory();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TrustManager
    private static TrustManager[] getTrustManager() {
        return new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
                // trust any client
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
                // trust any server
            }

            @Override
            public X509Certificate[] getAcceptedIssuers()
            {
                return new X509Certificate[]{};
            }
        }};
    }

    //HostnameVerifier
    public static HostnameVerifier getHostnameVerifier() {
        return (s, sslSession) -> true;
    }
}
