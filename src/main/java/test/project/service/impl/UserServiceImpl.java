package test.project.service.impl;

import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.project.dto.UserRequestDto;
import test.project.dto.UserResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.User;
import test.project.repository.UserRepository;
import test.project.service.RoleService;
import test.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final RequestDtoMapper<UserRequestDto, User> requestDtoMapper;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;

    public UserServiceImpl(PasswordEncoder encoder, UserRepository userRepository,
                           RoleService roleService, RequestDtoMapper<UserRequestDto, User> requestDtoMapper, ResponseDtoMapper<UserResponseDto, User> responseDtoMapper) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @Override
    public UserResponseDto add(UserRequestDto userRequestDto) {
        if (userRepository.existsByUsername(userRequestDto.getUsername())) {
            throw new RuntimeException("User with username already exists");
        }
        User user = requestDtoMapper.mapToModel(userRequestDto);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleService.findByRoleName("USER")));
        userRepository.save(user);
        return responseDtoMapper.mapToDto(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new RuntimeException("User with username " + username + " not found"));
    }
}
