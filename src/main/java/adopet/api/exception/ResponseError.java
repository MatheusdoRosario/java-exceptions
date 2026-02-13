package adopet.api.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(Object message, HttpStatus httpStatus, LocalDateTime time) {
}
