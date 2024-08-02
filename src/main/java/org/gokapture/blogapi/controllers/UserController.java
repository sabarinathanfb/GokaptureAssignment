package org.gokapture.blogapi.controllers;


import org.gokapture.blogapi.dtos.SignUpRequestDto;
import org.gokapture.blogapi.exception.UserAlreadyExistsException;
import org.gokapture.blogapi.models.User;
import org.gokapture.blogapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> signup(@RequestBody SignUpRequestDto request) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.signup(request.getUsername(),request.getPassword()), HttpStatus.ACCEPTED);
    }
}
