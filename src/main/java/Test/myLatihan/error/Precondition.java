package Test.myLatihan.error;

import Test.myLatihan.exception.BaseException;

public class Precondition {
    public static <T extends RuntimeException> void checkError(boolean error, BaseException exception) {
        if (error) {
            throw exception;
        }
    }
}
