package org.example.totgether3;
import org.apache.catalina.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("http://localhost:3306")
    public ResponseEntity<String> register(@RequestBody MyUser user) {
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody org.example.totgether3.MyUser user) {
        org.example.totgether3.MyUser foundUser = (org.example.totgether3.MyUser) userRepository.findByLogin(user.getLogin());
        if (foundUser != null && foundUser.checkPassword(user.getPassword())) {
            return ResponseEntity.ok("Login successful.");
        }
        return ResponseEntity.status(401).body("Invalid credentials.");
    }
}