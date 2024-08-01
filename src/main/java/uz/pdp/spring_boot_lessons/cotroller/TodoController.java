package uz.pdp.spring_boot_lessons.cotroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_boot_lessons.exceptions.ItemNotFoundException;
import uz.pdp.spring_boot_lessons.model.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/todo")
public class TodoController {

    AtomicInteger atomicInteger = new AtomicInteger(0);


    List<Todo> todos = new ArrayList<>(
            List.of(
                    new Todo(atomicInteger.getAndIncrement(), "Weak Up Early", "shja"),
                    new Todo(atomicInteger.getAndIncrement(), "Read Book", "shja"),
                    new Todo(atomicInteger.getAndIncrement(), "Play Some football", "shja")
            )
    );


    @GetMapping(value = "/all")
    public List<Todo> getTodos() {

        return todos;
    }


    @GetMapping(value = "/one/{id}")
    public Todo get(@PathVariable("id") int todoId) {

        Optional<Todo> optionalTodo = todos.stream()
                .filter(todo -> todo.getId() == todoId)
                .findFirst();

        return optionalTodo
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }


    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Todo todo) {
        todos.add(todo);
    }
}
