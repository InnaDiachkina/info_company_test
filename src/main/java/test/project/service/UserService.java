package test.project.service;

import test.project.dto.UserRequestDto;
import test.project.dto.UserResponseDto;
import test.project.model.User;

public interface UserService {
    UserResponseDto add(UserRequestDto userRequestDto);

    User findByUsername(String username);
}
