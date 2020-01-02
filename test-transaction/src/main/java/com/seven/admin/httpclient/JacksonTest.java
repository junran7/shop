package com.seven.admin.httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JR
 * @Date 2019/12/19 14:52
 **/
public class JacksonTest {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String json = JsonString.json;

        //json  <==> javabean

//        try {
//            User user = objectMapper.readValue(json, User.class);
//            System.out.println(user);
//
//            String s = objectMapper.writeValueAsString(user);
//            System.out.println(s);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }


        try {
            JsonNode jsonNode = objectMapper.readTree(json);

            JsonNode data = jsonNode.findPath("data");

            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Data.class);

            List<Data> datas = objectMapper.readValue(data.toString(), javaType);

            for (Data data1 : datas) {

                System.out.println(data1);

            }


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }


}
