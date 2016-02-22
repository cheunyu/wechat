package com.scyb.wechat.common;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/22
 * Time:16:11
 */
public class HttpClientUtil {
    public static CloseableHttpClient createSSLClientDefault() {

        try {

            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                //信任所有

                public boolean isTrusted(X509Certificate[] chain,

                                         String authType) throws CertificateException {

                    return true;

                }

            }).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);

            return HttpClients.custom().setSSLSocketFactory(sslsf).build();

        } catch (KeyManagementException e) {

            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        } catch (KeyStoreException e) {

            e.printStackTrace();

        }

        return HttpClients.createDefault();

    }
}
