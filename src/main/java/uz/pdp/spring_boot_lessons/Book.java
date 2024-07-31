package uz.pdp.spring_boot_lessons;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;
}
