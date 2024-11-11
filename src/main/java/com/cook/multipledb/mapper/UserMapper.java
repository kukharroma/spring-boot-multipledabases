package com.cook.multipledb.mapper;

import com.cook.multipledb.dto.UserDto;
import com.cook.multipledb.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserDto> map(List<User> users) {
        return users.stream().map(this::map).collect(Collectors.toList());
    }

    private UserDto map(User user) {
        return new UserDto(user.id(), user.username(), user.name(), user.surname());
    }



}
