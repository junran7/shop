package com.seven.admin.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author JR
 * @Date 2019/12/19 13:21
 **/
public class GetTest {

    public static String url ="http://localhost:8080/user/page?draw=1&start=1&length=5";



    public static void main(String[] args) {

        requsetGet(ConstantUtil.V1CONTENTSPPT);


    }

    private static String requsetGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
//        httpGet.setHeader("Cookie","JSESSIONID=C28C7993021619919293B0EF36C8CECF");
//        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
//        httpGet.setHeader("Connection:","keep-alive");

        try {

            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            HttpEntity entity = httpResponse.getEntity();

            String s = EntityUtils.toString(entity);
            System.out.println(s);

            return s;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        } finally {
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭");
                }
            }
            return null;
        }
    }

}
