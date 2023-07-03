package io.mkolodziejczyk92.anonymoussanta.data.controllers;

import io.mkolodziejczyk92.anonymoussanta.data.model.UserDto;
import io.mkolodziejczyk92.anonymoussanta.data.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//
//    @PostMapping
//    public void createUser(@RequestBody UserDto userDto) {
//        UserDto savedUser = userService.saveUser(userDto);
//    }
//
//    @GetMapping
//    public List<UserDto> getAllUsers() {
//        return UserService.getAllUsers();
//    }
//
//    @PutMapping("/{id}")
//    public void updateUserById(@RequestBody UserDto userDto, @PathVariable Long id) {
//        userService.updateUserById(id, userDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }
}
