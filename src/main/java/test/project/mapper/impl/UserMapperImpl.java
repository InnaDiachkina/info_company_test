package test.project.mapper.impl;

import org.springframework.stereotype.Component;
import test.project.dto.UserRequestDto;
import test.project.dto.UserResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.User;

@Component
public class UserMapperImpl implements RequestDtoMapper<UserRequestDto, User>,
        ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public User mapToModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        return userResponseDto;
    }
}
