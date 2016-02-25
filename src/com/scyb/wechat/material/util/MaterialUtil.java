package com.scyb.wechat.material.util;

import com.scyb.wechat.common.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/22
 * Time:14:22
 */
public class MaterialUtil {


    private static final String materalCountUrl = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
    private static final String materalListUrl = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
    private static String accessToken = "apwMcFwVAqEg_7vtp-cWQ-5qJwfCpaEVbfY5YrSftqNo9w-l4TEQNtyyySjghlL0_xJ_G4-rS7u-7BpFAzmxcY4jkV2OocQWlYWU3KMy2LvnQGHjMsJjnxf6B-QgvrgVKPLhAGAFKG";

    public static int getMaterialCount() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(materalCountUrl + accessToken);
        System.out.println("executing request " + httpget.getURI());
        try {
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                System.out.println("Response content: " + EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static void getMaterialList() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClientUtil.createSSLClientDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(materalListUrl + accessToken);

        // 创建参数队列
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair("type", "\'image\'"));
        formParams.add(new BasicNameValuePair("offset", "0"));
        formParams.add(new BasicNameValuePair("count", "3"));
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
                    CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getMaterialList1() {
        HttpPost post = new HttpPost(materalListUrl+accessToken);
        DefaultHttpClient client = new DefaultHttpClient();
        JSONObject jsonObject = new JSONObject();
        jsonObject.element("type", "image");
        jsonObject.element("offset", "0");
        jsonObject.element("count", "3");
        try {
            StringEntity s = new StringEntity(jsonObject.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            System.out.println(res.getStatusLine().getStatusCode());
            HttpEntity entity = res.getEntity();
            String charset = EntityUtils.getContentCharSet(entity);
            System.out.println(EntityUtils.toString(entity));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
//        MaterialUtil.getMaterialCount();
        MaterialUtil.getMaterialList1();
    }
}
