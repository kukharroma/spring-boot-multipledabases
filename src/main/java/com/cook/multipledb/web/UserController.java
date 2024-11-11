package com.cook.multipledb.web;

import com.cook.multipledb.dto.UserDto;
import com.cook.multipledb.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get aggregated user data from multiple databases")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user data")
    })
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

}
