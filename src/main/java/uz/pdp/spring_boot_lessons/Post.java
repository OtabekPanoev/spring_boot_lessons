package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private int id = 10;
    private Integer userId;
    private String title;
    @JsonProperty("content")
    private String body;
}
