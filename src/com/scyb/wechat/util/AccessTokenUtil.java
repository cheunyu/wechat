package com.scyb.wechat.util;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/18
 * Time:13:59
 */
public class AccessTokenUtil {

    /**
     * ???? get????
     */
    public static void get() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx8d2169cd27749791&secret=0da55481c043d802d5a120b66bbe3540";
        try {
            // ????httpget.
            HttpGet httpget = new HttpGet(url);
            System.out.println("executing request " + httpget.getURI());
            // ???get????.
            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                // ?????????
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // ????????
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // ?????????????
                    System.out.println("Response content length: " + entity.getContentLength());
                    // ??????????
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
                System.out.println("------------------------------------");
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            // ???????,??????
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        AccessTokenUtil.get();
    }

}
