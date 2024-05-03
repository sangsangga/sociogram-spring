package Test.myLatihan.Controller;

import Test.myLatihan.Contract.AuthService;
import Test.myLatihan.dto.RegisterUserRequestDTO;
import Test.myLatihan.dto.RegisterUserResponseDTO;
import Test.myLatihan.dto.ResponseDTO;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseDTO<RegisterUserResponseDTO> register(
            @RequestBody RegisterUserRequestDTO request
            ) {
        return ResponseDTO.ok(authService.registerUser(request));
    }
}
