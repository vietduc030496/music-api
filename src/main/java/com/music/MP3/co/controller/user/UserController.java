package com.music.MP3.co.controller.user;

import com.music.MP3.co.domain.dto.response.BaseResponse;
import com.music.MP3.co.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable("id") long userId, @RequestBody Map<String, Object> attribute) {
        BaseResponse updateResult = userService.update(userId, attribute);
        return ResponseEntity.status(updateResult.getStatusCode()).body(updateResult);
    }
}
