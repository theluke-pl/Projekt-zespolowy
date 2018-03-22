package pl.nakiel.projektZespolowy.utils.converter;

import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.resources.dto.common.UserDTO;

import java.util.stream.Collectors;

@Service
public class UserUserDTOConverter {
    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFacebookId(user.getFacebookId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setId(user.getId());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRoles(user.getRoles().stream().map(r->r.getName()).collect(Collectors.toList()));
        userDTO.setSecondName(user.getSecondName());
        userDTO.setStatus(user.getStatus());
        return userDTO;
    }
}
