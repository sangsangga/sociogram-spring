package Test.myLatihan.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class BaseException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;
}
