package pl.nakiel.projektZespolowy.resources.dto.changepassword;

import lombok.Data;

@Data
public class ChangePasswordRequestDTO {
    private String oldPassword;
    private String newPassword;
}
