package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserDTO getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    public static String generateShortId() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", ""); // Remove dashes
        return uuidString.substring(0, 5);
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        String shortId = generateShortId();
        userDTO.setId(shortId); // Generate UUID
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }


}
