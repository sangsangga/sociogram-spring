package Test.myLatihan.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {
    private String message;
    private String code;
    private T data;
    private T errors;


    public static <T> ResponseDTO<T> ok(T data){
        ResponseDTO<T> res = new ResponseDTO<>();
        res.setData(data);
        res.setMessage("");
        return res;
    }
}
