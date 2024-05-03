package Test.myLatihan.error;

import Test.myLatihan.dto.ResponseDTO;
import Test.myLatihan.exception.BaseException;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ResponseDTO<String>> errorHandler(BaseException e, HttpServletResponse response){
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        responseDTO.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDTO, e.getHttpStatus());
    }
}
