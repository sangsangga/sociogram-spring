package Test.myLatihan.error;

import Test.myLatihan.exception.BaseException;
import org.springframework.http.HttpStatus;

public class AuthError {
    public static BaseException existUserRegisterByEmail() {
        return BaseException
                .builder()
                .message("User with specified credential already registered")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    public static BaseException existUserRegisterByUsername() {
        return BaseException
                .builder()
                .message("User with specified credential already registered")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    public static BaseException registerPasswordNotValid() {
        return BaseException
                .builder()
                .message("Password not valid")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }
}
