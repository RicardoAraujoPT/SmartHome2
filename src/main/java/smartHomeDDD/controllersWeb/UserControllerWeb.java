package smartHomeDDD.controllersWeb;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartHomeDDD.domain.user.User;
import smartHomeDDD.services.ServiceUser;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerWeb {

    private final ServiceUser _userService;

    public UserControllerWeb(ServiceUser userService) {
        this._userService = userService;
    }


    @GetMapping("")
    public ResponseEntity<?>  getUsers() {
        List<User> users = (List<User>) _userService.findAll();
        System.out.println(users);
        return new ResponseEntity<>(users, HttpStatus.OK);

    }



   /* @PostMapping("/{name}")
    public void changeToAdmin(@PathVariable String name) {
        Optional<User> user = _userService.findByName(name);
        if (user.isPresent()) {
            UserName userName = new UserName(name);
            RoleName roleName = RoleName.ADMIN;
            _userService.updateUserRole(userName, roleName);
        }



    }*/


}
