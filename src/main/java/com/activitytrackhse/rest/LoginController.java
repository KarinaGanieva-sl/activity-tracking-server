package com.activitytrackhse.rest;

import com.activitytrackhse.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {


    @GetMapping(value = "/login")
    public ResponseEntity<?> login(@RequestParam String nickname, @RequestParam String password) {
        Map<Object, Object> model = new HashMap<>();
        if (user != null) {
            List<String> roles = new ArrayList<>();
            roles.add(user.getRole());
            String token = jwtTokenProvider.createToken(nickname, roles);
            model.put("user", user);
            model.put("token", token);
            //model.put("role", user.getRole());
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
