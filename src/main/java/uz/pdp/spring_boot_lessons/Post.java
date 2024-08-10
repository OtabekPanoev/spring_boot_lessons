package uz.pdp.spring_boot_lessons;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
