package uz.pdp.spring_boot_lessons.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorDto {

    private Integer status;
    private String path;
    private Object body;
}
