package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot_lessons.serialization.LocalDateDeserializer;
import uz.pdp.spring_boot_lessons.serialization.LocalDateSerializer;
import uz.pdp.spring_boot_lessons.serialization.LocalDateTimeSerializer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ObjectMapperTestTime {
    public static void main(String[] args) throws Exception {

        String json = """
                {
                    "localDate": "2024-10-10"
                }
                """;

        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

//        String json = mapper.writeValueAsString(new TimeTest());
//        System.out.println(json);

        TimeTest timeTest = mapper.readValue(json, TimeTest.class);
        System.out.println(timeTest.getLocalDate());

    }

}

@Getter
@Setter
class TimeTest {

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate localDate = LocalDate.now();

//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime localDateTime = LocalDateTime.now();
}