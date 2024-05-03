package Test.myLatihan.Contract;

import Test.myLatihan.dto.RegisterUserRequestDTO;
import Test.myLatihan.dto.RegisterUserResponseDTO;

public interface AuthService {
    RegisterUserResponseDTO registerUser(RegisterUserRequestDTO dto);
}
