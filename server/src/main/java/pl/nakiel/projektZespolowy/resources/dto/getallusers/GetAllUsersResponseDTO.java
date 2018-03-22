package pl.nakiel.projektZespolowy.resources.dto.getallusers;

import lombok.Data;
import pl.nakiel.projektZespolowy.resources.dto.common.UserDTO;

import java.util.List;

@Data
public class  GetAllUsersResponseDTO {
    private List<UserDTO> users;

}
