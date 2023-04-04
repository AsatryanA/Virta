package fi.devolon.virta.exception;

import fi.devolon.virta.exception.massages.ErrorMassages;
import jakarta.persistence.EntityExistsException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handleEntityNotFoundException(HttpServletRequest req, ResourceNotFoundException e) {
        return buildResponse(HttpStatus.NOT_FOUND, String.format(ErrorMassages.ENTITY_NOT_FOUND, e.getMessage()), req.getRequestURI());
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleEntityExistsException(HttpServletRequest req, EntityExistsException e) {
        return buildResponse(HttpStatus.BAD_REQUEST, ErrorMassages.ENTITY_EXIST, req.getRequestURI());
    }

    private ResponseEntity<ApiError> buildResponse(HttpStatus httpCode, String message, String requestURI) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", message);
        ApiError apiError = new ApiError(httpCode.value(), requestURI, errors);
        return ResponseEntity.status(httpCode).body(apiError);
    }
}
