package uz.pdp.spring_boot_lessons.cotroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_boot_lessons.payload.TodoCreateDto;
import uz.pdp.spring_boot_lessons.payload.TodoDto;
import uz.pdp.spring_boot_lessons.service.TodoService;

import java.util.UUID;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/one")
    public TodoDto findById(@RequestParam UUID id) {
        return todoService.findById(id);
    }

    @PostMapping("/create")
    public TodoDto create( @RequestBody TodoCreateDto dto) {
        return todoService.create(dto);
    }
}
