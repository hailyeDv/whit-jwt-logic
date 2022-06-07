package com.example.withjwt.domain.authority;

import com.example.withjwt.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "authoritys")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Authority extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long id;

    @Column
    private String authorityName;
}
