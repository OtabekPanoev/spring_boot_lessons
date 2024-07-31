package uz.pdp.spring_boot_lessons;


import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        ErrorDto errorDto = ErrorDto.builder()
                .url(request.getRequestURI())
                .message(ex.getMessage())
                .statusCode(ex.getStatusCode().value())
                .build();

        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }


}
