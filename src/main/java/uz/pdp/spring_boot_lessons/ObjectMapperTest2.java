package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

public class ObjectMapperTest2 {
    public static void main(String[] args) throws Exception {

        json2();
//        json1();
//        json2();
//        jsonToMap();
//        pojoToJson();
    }

    private static void json1() throws JsonProcessingException {
        String json = """
                {
                  "userId": 1,
                  "id": null,
                  "name": "John",
                  "title": "sunt aut facere repellat provident",
                  "body": "quia et "
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

        Post post = objectMapper.readValue(json, Post.class);
        System.out.println(post);
    }

    private static void json2() throws JsonProcessingException {
        String json = """
                {
                  "id": 1,
                  "name": "John",
                  "statusCode": "01"
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);

    }



}

@Getter
@Setter
@ToString
class User {
    public int id;
    public String name;

    @JsonProperty("statusCode")
    public UserStatus status;
}

