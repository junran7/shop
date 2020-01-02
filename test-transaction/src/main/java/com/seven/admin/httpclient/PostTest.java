package com.seven.admin.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author JR
 * @Date 2019/12/19 14:27
 **/
public class PostTest {


    public static void main(String[] args) {

        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8080/user/page");

//        httpPost.setHeader("Cookie","JSESSIONID=C28C7993021619919293B0EF36C8CECF");
//        httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
//        httpPost.setHeader("Connection:","keep-alive");

        List<BasicNameValuePair>  params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("draw","1"));
        params.add(new BasicNameValuePair("start","1"));
        params.add(new BasicNameValuePair("length","5"));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));

            HttpResponse httpResponse = httpClient.execute(httpPost);

            HttpEntity entity = httpResponse.getEntity();

            System.out.println(EntityUtils.toString(entity));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
