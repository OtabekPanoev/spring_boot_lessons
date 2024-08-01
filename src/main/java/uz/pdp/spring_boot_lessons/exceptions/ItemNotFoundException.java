package uz.pdp.spring_boot_lessons.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends NoSuchElementException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
