package pl.nakiel.projektZespolowy.resources.dto.createstandarduser;

import lombok.Data;
import pl.nakiel.projektZespolowy.resources.dto.common.UserDTO;

@Data
public class CreateStandardUserRequestDTO {
    UserDTO user;
}
