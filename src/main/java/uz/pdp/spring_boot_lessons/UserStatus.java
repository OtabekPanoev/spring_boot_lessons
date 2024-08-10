package uz.pdp.spring_boot_lessons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    ACTIVE("01"),
    IN_ACTIVE("02"),
    PROCESSING("03");

    private final String code;
}
