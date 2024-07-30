package uz.pdp.spring_boot_lessons;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String username;
    private String password;
}
