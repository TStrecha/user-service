package cz.thomas.messagingapp.userservice.controller;


import cz.thomas.messagingapp.userservice.dto.UserDTO;
import cz.thomas.messagingapp.userservice.dto.UserRegisterDTO;
import cz.thomas.messagingapp.userservice.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cz.thomas.messagingapp.userservice.constants.Constants.API_V1;

@RestController
@Api(value = "Basic user controller", tags = "user-controller")
@RequiredArgsConstructor
@RequestMapping(API_V1 + "/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/by-username/{username}")
    public UserDTO getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping("/")
    public UserDTO registerUser(@RequestBody UserRegisterDTO registerDTO){
        return userService.registerUser(registerDTO);
    }

}
