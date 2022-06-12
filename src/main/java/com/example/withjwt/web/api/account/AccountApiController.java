package com.example.withjwt.web.api.account;

import com.example.withjwt.domain.user.User;
import com.example.withjwt.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountApiController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody User saveData) {

        if (userService.findByUserName(saveData.getUserName()) != null) {
            throw new EntityExistsException("이미 존재하는 계정입니다.");
        }

        Long id = userService.save(saveData);

        return ResponseEntity.ok(id);
    }

}
