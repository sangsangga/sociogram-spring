package Test.myLatihan.Service;

import Test.myLatihan.Contract.PasswordHashService;
import com.password4j.Password;
import org.springframework.stereotype.Service;

@Service
public class PasswordHashServiceImpl implements PasswordHashService {
    @Override
    public String passwordHash(String password) {
        return Password.hash(password).withBcrypt().getResult();
    }

    @Override
    public boolean checkPassword(String password, String hashPassword) {
        return Password.check(password, hashPassword).withBcrypt();
    }
}
