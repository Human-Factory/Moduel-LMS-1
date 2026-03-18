package com.habis.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

// 66
// jpa가 이 클래스를 DB와 매핑할 대상으로 인식하게 하는 어노테이션입니다~
@Entity
// 테이블 명을 "members로 명시적 지정
@Table(name = "members")
// lombok으로 모든 필드의 getter 생성
@Getter

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    // 아이디: 영문+숫자 6~20자, 중복 불가
    @Column(name = "login_id", nullable = false, unique = true, length = 20)
    private String loginId;

    // 비밀번호: BCrypt 암호화 저장
    @Column(nullable = false, length = 255)
    private String password;

    // 닉네임
    @Column(nullable = false, length = 30)
    private String nickname;

    // 이름: 한글 5글자 이내
    @Column(nullable = false, length = 20)
    private String name;

    // 이메일 (선택)
    @Column(length = 100)
    private String email;

    // 전화번호 (선택)
    @Column(length = 20)
    private String phone;

    // 역할: USER, PREMIUM, INSTRUCTOR, ADMIN
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Role role = Role.USER;

    // 계정 상태: ACTIVE, INACTIVE, BANNED
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Status status = Status.ACTIVE;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // -----------------------------------------------
    // 비즈니스 메서드
    // -----------------------------------------------

    // 비밀번호 변경
    public void updatePassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    // 개인정보 수정 (닉네임, 이름, 전화번호, 이메일)
    public void updateInfo(String nickname, String name, String phone, String email) {
        this.nickname = nickname;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // 프리미엄 업그레이드
    public void upgradeToPremium() {
        this.role = Role.PREMIUM;
    }

    // 프리미엄 해지
    public void downgradeToUser() {
        this.role = Role.USER;
    }

    // 회원 탈퇴 (비활성화)
    public void deactivate() {
        this.status = Status.INACTIVE;
    }

    // 계정 정지
    public void ban() {
        this.status = Status.BANNED;
    }

    // 계정 활성화
    public void activate() {
        this.status = Status.ACTIVE;
    }

    // 프리미엄 여부 확인
    public boolean isPremium() {
        return this.role == Role.PREMIUM || this.role == Role.ADMIN;
    }

    // 관리자 여부 확인
    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

    // -----------------------------------------------
    // ENUM
    // -----------------------------------------------

    //이건 가입자의 권한을 나타냅니다. 일반회원, 프리미엄 회원, 강의자, 관리자
    public enum Role {
        USER, PREMIUM, INSTRUCTOR, ADMIN
    }

    // 이건 회원 상태 활성, 비활성(탈퇴, 비활성), 차단
    public enum Status {
        ACTIVE, INACTIVE, BANNED
    }
}