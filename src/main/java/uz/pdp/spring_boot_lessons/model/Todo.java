package uz.pdp.spring_boot_lessons.model;

import lombok.*;
import uz.pdp.spring_boot_lessons.model.enums.StatusEnum;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todo {
    private UUID id;
    private String title;
    private StatusEnum status;
    private Boolean deleted;

    public boolean getDeleted() {
        return deleted != null && deleted;
    }
}
