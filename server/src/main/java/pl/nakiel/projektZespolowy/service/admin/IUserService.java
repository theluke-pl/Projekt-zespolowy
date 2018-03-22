package pl.nakiel.projektZespolowy.service.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.resources.dto.createstandarduser.CreateStandardUserRequestDTO;
import pl.nakiel.projektZespolowy.resources.dto.initfacebookuser.InitFacebookUserRequestDTO;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    List<User> getUsersByRole(String role);
    User getCurrentUser();

    void changePassword(String oldPassword, String newPassword);

    void createStandardUser(CreateStandardUserRequestDTO createStandardUserRequestDTO);

    void initFacebookUser(InitFacebookUserRequestDTO initFacebookUserRequestDTO);

}
