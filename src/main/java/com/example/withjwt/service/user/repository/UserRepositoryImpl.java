package com.example.withjwt.service.user.repository;

import com.example.withjwt.common.code.Used;
import com.example.withjwt.domain.user.QUser;
import com.example.withjwt.domain.user.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.withjwt.domain.user.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryQueryDsl {

    private final JPAQueryFactory queryFactory;

    public User findByUsername(String username) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(user.userName.eq(username));
        builder.and(user.activated.eq(Used.Y));

        return queryFactory
                .select(user)
                .from(user)
                .where(builder)
                .fetchOne();
    }
}
