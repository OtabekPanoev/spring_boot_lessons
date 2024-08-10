package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ObjectMapperTest {
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
                  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                  "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                }
                """;

        // userId
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Post post = objectMapper.readValue(json, Post.class);
        System.out.println(post);
        System.out.println("------------");
//        String jsonStr = objectMapper.writeValueAsString(post);
//        System.out.println(jsonStr);
    }


    private static void json2() throws JsonProcessingException {
        String json = """
                [
                            {
                              "userId": 1,
                              "id": 1,
                              "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                              "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                            },
                            {
                               "userId": 1,
                               "id": 1,
                               "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                               "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                            }
                ]
                """;

        ObjectMapper objectMapper = new ObjectMapper();

        /*Post[] posts = objectMapper.readValue(json, Post[].class);
        Arrays.stream(posts)
                .forEach(System.out::println);*/

//        objectMapper.readValue(json, List<Post>.class);
        List<Post> posts = objectMapper.readValue(json, new TypeReference<List<Post>>() {
        });

        posts.forEach(System.out::println);

    }


    private static void jsonToMap() throws Exception {
        String json = """
                {
                  "userId": 1,
                  "id": 1,
                  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                  "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, String> map = objectMapper.readValue(json, new TypeReference<Map<String, String>>() {});

//        System.out.println(map);
        String userId = map.get("userId");
        System.out.println(userId);
    }


    private static void pojoToJson() throws Exception {

        Post post = Post.builder()
                .id(10)
                .userId(20)
                .title("Swimming Healthy")
                .body("whegkrvfhjqwebfjewbb")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

//        String json = objectMapper.writeValueAsString(post);
//        byte[] bytes = objectMapper.writeValueAsBytes(post);

//        System.out.println(json);

//        File file = new File("src/main/resources/posts.json");
//        objectMapper.writeValue(file, post);

//        OutputStream file = new FileOutputStream("src/main/resources/posts2.json");
//        objectMapper.writeValue(file, List.of(post));

    }
}
