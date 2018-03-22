package pl.nakiel.projektZespolowy.resources.dto.getcurrentuser;

import lombok.Data;
import pl.nakiel.projektZespolowy.resources.dto.common.UserDTO;

@Data
public class GetCurrentUserResponseDTO {
    private UserDTO user;
}
