package uz.pdp.spring_boot_lessons.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot_lessons.model.Todo;
import uz.pdp.spring_boot_lessons.model.enums.StatusEnum;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoDto {
    private UUID id;
    private String title;
    private StatusEnum completed;

    public static TodoDto from(Todo todo) {
        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setCompleted(todo.getStatus());
        return dto;
    }

}
