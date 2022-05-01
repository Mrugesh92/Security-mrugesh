package userMangement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserResource {

    public static final String HELLO_USER = "Hello user";


    @Autowired
    private UserService userService;

    @GetMapping("/login-using-spring-security")
    public String userLoginWithSpringSecurity(){
        return HELLO_USER;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<Map<String,String>> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {
        Map<String,String> token = new HashMap<>();
        token.put("accessToken",userService.authentication(userDTO.getUserName(), userDTO.getPassword())) ;
        return ResponseEntity.ok(token);
    }

    @GetMapping("/api/login")
    public String userLoginWithJwt(){
        return HELLO_USER;
    }

    @PostMapping("/api/user")
    public void saveUser(UserDTO userDTO){
        userService.save(userDTO);
    }

}
