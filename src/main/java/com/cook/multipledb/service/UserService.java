package com.cook.multipledb.service;

import com.cook.multipledb.config.DataSourcesProperties;
import com.cook.multipledb.dto.UserDto;
import com.cook.multipledb.mapper.UserMapper;
import com.cook.multipledb.model.User;
import com.cook.multipledb.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final DataSourcesProperties dataSourcesProperties;

    @Autowired
    public UserService(UserMapper userMapper, UserRepository userRepository, DataSourcesProperties dataSourcesProperties) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.dataSourcesProperties = dataSourcesProperties;
    }

    public List<UserDto> getUsers() {
        List<User> data = dataSourcesProperties.getSources().stream()
                .flatMap(config -> userRepository.getUsers(config).stream())
                .collect(Collectors.toList());

        log.info("Retrieved in total {} users", data.size());

        return userMapper.map(data);
    }

}

