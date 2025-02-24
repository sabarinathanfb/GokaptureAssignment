package org.gokapture.blogapi.controllers;


import org.gokapture.blogapi.Mapper.Mapper;
import org.gokapture.blogapi.dtos.LoginRequestDto;
import org.gokapture.blogapi.dtos.SignUpRequestDto;
import org.gokapture.blogapi.dtos.UserDto;
import org.gokapture.blogapi.exception.UserAlreadyExistsException;
import org.gokapture.blogapi.exception.UserDoesNotFoundException;
import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.services.TaskService;
import org.gokapture.blogapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> signup(@RequestBody SignUpRequestDto request) throws UserAlreadyExistsException {
        return new ResponseEntity<>(Mapper.toDto(userService.signup(request.getUsername(),request.getPassword())), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) throws UserDoesNotFoundException {

        String token = userService.login(request.getUsername(), request.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);

    }


}
