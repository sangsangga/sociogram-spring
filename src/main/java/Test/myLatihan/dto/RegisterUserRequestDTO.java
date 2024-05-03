package Test.myLatihan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    public String username;
    public String email;
    public String password;
}
