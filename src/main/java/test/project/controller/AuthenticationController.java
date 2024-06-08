package test.project.controller;

import org.springframework.web.bind.annotation.*;
import test.project.dto.UserRequestDto;
import test.project.dto.UserResponseDto;
import test.project.service.UserService;

@RestController
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        return userService.add(requestDto);
    }
}
