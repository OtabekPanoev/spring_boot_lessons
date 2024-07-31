package uz.pdp.spring_boot_lessons;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    private String message;
    private int statusCode;
    private String url;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
