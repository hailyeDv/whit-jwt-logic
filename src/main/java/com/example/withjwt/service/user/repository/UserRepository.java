package com.example.withjwt.service.user.repository;

import com.example.withjwt.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryQueryDsl {
}
