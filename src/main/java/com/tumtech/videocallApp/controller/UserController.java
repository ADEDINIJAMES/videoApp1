package com.tumtech.videocallApp.controller;

import com.tumtech.videocallApp.service.UserService;
import com.tumtech.videocallApp.users.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor // to inject my dependencies
@CrossOrigin(origins="*")
@Slf4j
public class UserController {
    private final UserService userService;
@PostMapping
    public  void register (Users users){
      userService.register(users);
    }
@PostMapping("/login")
    public Users login (Users users){
        return userService.login(users);
    }
@PostMapping("/logout")
    public void logout (String email){
       userService.logout(email);
    }
@GetMapping
    public List<Users> findAll(){
        return userService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>handle (Exception ex){
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

}
