package uz.pdp.spring_boot_lessons.exceptions;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorDto {
    private String message;
    private String path;
    private Integer status;
}
