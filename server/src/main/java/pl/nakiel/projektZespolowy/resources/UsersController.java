package pl.nakiel.projektZespolowy.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nakiel.projektZespolowy.resources.dto.ChangePasswordRequestDTO;
import pl.nakiel.projektZespolowy.resources.dto.ChangePasswordResponseDTO;
import pl.nakiel.projektZespolowy.service.admin.IUserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {

    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping(value = "",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO){
        userService.changePassword(
                changePasswordRequestDTO.getUserId(),
                changePasswordRequestDTO.getNewPassword()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
