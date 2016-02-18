package com.scyb.wechat.material.util;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2016/2/18
 * Time:16:37
 */
public class UploadMediaUtil {


    public static JSONObject uploadMedia(File file, String token, String type) throws IOException {
        if(file==null||token==null||type==null){
            return null;
        }
        if(!file.exists()){
            System.out.println("上传文件不存在,请检查!");
            return null;
        }
        String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
        JSONObject jsonObject = null;
        PostMethod post = new PostMethod(url);
        post.setRequestHeader("Connection", "Keep-Alive");
        post.setRequestHeader("Cache-Control", "no-cache");
        FilePart media = null;
        HttpClient httpClient = new HttpClient();
        //信任任何类型的证书
//        Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);
//        Protocol.registerProtocol("https", myhttps);


            media = new FilePart("media", file);
            Part[] parts = new Part[] { new StringPart("access_token", token),
                    new StringPart("type", type), media };
            MultipartRequestEntity entity = new MultipartRequestEntity(parts,
                    post.getParams());
            post.setRequestEntity(entity);
            int status = httpClient.executeMethod(post);
            if (status == HttpStatus.SC_OK) {
                String text = post.getResponseBodyAsString();
                jsonObject = JSONObject.fromObject(text);
            } else {
                System.out.println("upload Media failure status is:" + status);
            }
        System.out.println(jsonObject.toString());
        return jsonObject;
    }


    public static void main(String args[]) {
        File file = new File("C:\\Users\\foo\\Desktop\\0.jpg");
        try {
            UploadMediaUtil.uploadMedia(file, "YQjzEIbVhcj4qjUt2b0wWGYpBLzu-kA_hVgCupGz42jpxDr5F2W6TDnZrlQXCbgSZqFQ1HidhfR3qZz6vpYqKPgTS-iPX1nmT9HihuG-Fr1sAOzvSZov58uDXuwkncmaCMGiAFAWGA", "image");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
