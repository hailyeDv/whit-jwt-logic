package com.example.withjwt.domain.user;

import com.example.withjwt.common.code.Gender;
import com.example.withjwt.common.code.Used;
import com.example.withjwt.common.domain.BaseEntity;
import com.example.withjwt.domain.authority.Authority;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 50)
    private String userName;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Used activated;

    @ManyToMany
    @JoinTable(name = "user_authority",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authority;
}
