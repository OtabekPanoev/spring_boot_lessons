package uz.pdp.spring_boot_lessons.conf;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.spring_boot_lessons.payload.ErrorDto;
import uz.pdp.spring_boot_lessons.exceptions.ItemNotFoundException;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorDto> handleItemNotFoundException(ItemNotFoundException e, HttpServletRequest request) {

        ErrorDto errorDto = ErrorDto.builder()
                .body(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        /*Map<String, String> errors = new HashMap<>();*/
        List<String> errors = new LinkedList<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            errors.add(fieldError.getField() + " " +fieldError.getDefaultMessage());
        }

        ErrorDto errorDto = ErrorDto.builder()
                .path(request.getRequestURI())
                .status(HttpStatus.BAD_REQUEST.value())
                .body(errors)
                .build();

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
