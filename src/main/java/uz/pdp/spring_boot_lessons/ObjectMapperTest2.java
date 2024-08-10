package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class ObjectMapperTest2 {
    public static void main(String[] args) throws Exception {

        json1();
//        json2();
//        jsonToMap();
//        pojoToJson();
    }

    private static void json1() throws JsonProcessingException {
        String json = """
                {
                  "userId": 1,
                  "id": 1,
                  "name": "John",
                  "title": "sunt aut facere repellat provident",
                  "body": "quia et "
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Post post = objectMapper.readValue(json, Post.class);
        System.out.println(post);
    }



}
