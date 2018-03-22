package pl.nakiel.projektZespolowy.resources.dto.common;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private Integer status;
    private String facebookId;
    private LocalizationDTO localizationDTO;
    private List<String> roles;
}
