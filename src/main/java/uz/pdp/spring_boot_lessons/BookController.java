package uz.pdp.spring_boot_lessons;

import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    List<Book> books = new ArrayList<>(
            List.of(
                    new Book(1, "O'tkan Kunlar", "Abdulla Qodiriy"),
                    new Book(2, "Shum Bola", "G'ofur G'ulom")
            )
    );

    @GetMapping(
            value = "/books",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Book> getBooks() {
        return books;
    }

    @PostMapping(value = "/add")
    public Book addBook(@Valid @RequestBody Book book) {
        books.add(book);
        return book;
    }
}
