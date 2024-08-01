package uz.pdp.spring_boot_lessons.payload;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import uz.pdp.spring_boot_lessons.model.enums.StatusEnum;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TodoCreateDto {

    @NotBlank
    @Size(min = 3, max = 10)
    private String title;

    private StatusEnum completed;

    @NotNull
    @AssertFalse
    private Boolean deleted;

//    @NotNull
    @NotEmpty
    @Size(min = 2)
    private List<String> params;

    @Min(20)
    private int age;

    @NotBlank
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = " invalid")
    private String username;

    @Digits(integer = 10, fraction = 2)
    private double price;
}
