package uz.pdp.spring_boot_lessons.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_lessons.exceptions.ItemNotFoundException;
import uz.pdp.spring_boot_lessons.model.Todo;
import uz.pdp.spring_boot_lessons.payload.TodoCreateDto;
import uz.pdp.spring_boot_lessons.payload.TodoDto;
import uz.pdp.spring_boot_lessons.repository.TodoRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoDto findById(UUID id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Todo not found"));

        return TodoDto.from(todo);
    }

    public TodoDto create(TodoCreateDto dto) {
        System.out.println(dto);
        return null;
    }
}
