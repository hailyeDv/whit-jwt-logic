package com.example.withjwt.service.user;

import com.example.withjwt.domain.authority.Authority;
import com.example.withjwt.domain.user.User;
import com.example.withjwt.service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public Long save(User saveData) {
        User user = User.of(saveData, Authority.of(1L));
        return userRepository.save(user).getId();
    }
}
