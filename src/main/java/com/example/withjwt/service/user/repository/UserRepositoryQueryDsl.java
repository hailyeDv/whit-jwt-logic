package com.example.withjwt.service.user.repository;

import com.example.withjwt.domain.user.User;

public interface UserRepositoryQueryDsl {

    User findByUsername(String username);
}
