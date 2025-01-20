package com.highFour.Hand2Hand.domain.member.entity;

import com.highFour.Hand2Hand.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String nickname;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private Address address;

    private String profileImgUrl;

    @ColumnDefault("0")
    private int reportCnt;

    @NotNull
    private String phone;

    @ColumnDefault("50")
    private int score;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    private boolean isVerified = false;

}
