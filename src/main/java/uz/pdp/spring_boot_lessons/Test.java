package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(new Student());
        System.out.println(s);
    }
}

@Getter
@Setter
class Student {
    private LocalDateTime time = LocalDateTime.now();
}
