package uz.pdp.spring_boot_lessons.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Todo {
    private int id;
    private String title;
    private String description;
    private boolean completed;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public Todo(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }
}
