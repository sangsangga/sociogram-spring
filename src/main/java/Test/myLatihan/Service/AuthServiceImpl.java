package Test.myLatihan.Service;

import Test.myLatihan.Contract.AuthService;
import Test.myLatihan.Contract.PasswordHashService;
import Test.myLatihan.Model.User;
import Test.myLatihan.Repository.UserRepository;
import Test.myLatihan.dto.RegisterUserRequestDTO;
import Test.myLatihan.dto.RegisterUserResponseDTO;
import Test.myLatihan.error.AuthError;
import Test.myLatihan.error.Precondition;
import Test.myLatihan.exception.BaseException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final int MIN_LENGTH_PASSWORD = 8;
    private final PasswordHashService passwordHashService;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordHashService passwordHashService) {
        this.userRepository = userRepository;
        this.passwordHashService = passwordHashService;
    }

    @Override
    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO requestDTO) {
        if(requestDTO.getEmail().isEmpty()) {
            throw BaseException
                    .builder()
                    .message("Email can't be empty")
                    .build();
        }

        if (requestDTO.getUsername().isEmpty()) {
            throw BaseException
                    .builder()
                    .message("Username can't be empty")
                    .build();
        }

        if (requestDTO.getPassword().isEmpty()) {
            throw BaseException
                    .builder()
                    .message("Password can't be empty")
                    .build();
        }

        checkUserRegistered(requestDTO);
        checkPasswordValid(requestDTO);

        String email = requestDTO.getEmail();
        String password = requestDTO.getPassword();
        String username = requestDTO.getUsername();
        String hashPassword = passwordHashService.passwordHash(password);

        User userToSave = new User();
        userToSave.setEmail(email);
        userToSave.setUsername(username);
        userToSave.setPassword(hashPassword);

        userRepository.save(userToSave);


        return RegisterUserResponseDTO.builder()
                .token(createToken(userToSave))
                .build();
    }


    private void checkUserRegistered(RegisterUserRequestDTO requestDTO) {
        User userByEmail = userRepository.findByEmail(requestDTO.getEmail());
        Precondition.checkError(!Objects.isNull(userByEmail), AuthError.existUserRegisterByEmail());

        User userByUserName = userRepository.findByUsername(requestDTO.getUsername());
        Precondition.checkError(!Objects.isNull(userByUserName), AuthError.existUserRegisterByUsername());
    }


    private void checkPasswordValid(RegisterUserRequestDTO requestDTO) {
        String password = requestDTO.getPassword();;

        Precondition.checkError(password.length() < MIN_LENGTH_PASSWORD, AuthError.registerPasswordNotValid());
    }

    private String createToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 230 * 1000))
                .signWith(SignatureAlgorithm.HS256, "secret").compact();

    }

}
