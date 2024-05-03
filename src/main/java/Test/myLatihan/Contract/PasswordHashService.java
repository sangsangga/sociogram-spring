package Test.myLatihan.Contract;

public interface PasswordHashService {
    String passwordHash(String password);
    boolean checkPassword(String password, String hashPassword);
}
