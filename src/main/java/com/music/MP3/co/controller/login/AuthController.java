package com.music.MP3.co.controller.login;

import com.music.MP3.co.domain.dto.request.login.LoginRequest;
import com.music.MP3.co.domain.dto.request.login.SignupRequest;
import com.music.MP3.co.domain.dto.response.BaseResponse;
import com.music.MP3.co.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService userService;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequest request) {
        BaseResponse loginResultResponse = userService.login(request);
        return ResponseEntity.status(loginResultResponse.getStatusCode()).body(loginResultResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<BaseResponse> signup(@RequestBody SignupRequest request) {
        BaseResponse signupResultResponse = userService.signup(request);
        return ResponseEntity.status(signupResultResponse.getStatusCode()).body(signupResultResponse);
    }

}
