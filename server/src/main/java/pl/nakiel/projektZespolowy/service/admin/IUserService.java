package pl.nakiel.projektZespolowy.service.admin;

import pl.nakiel.projektZespolowy.domain.security.User;

import java.util.List;
import java.util.Set;

public interface IUserService {
    List<User> getAllUsers();

    List<User> getUsersByRole(String role);

    void changePassword(Long userId, String password);
}
