package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;


@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // BIGINT 반영

    @Column(name = "login_id", nullable = false, unique = true, length = 50)
    private String loginId;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "employee_no", nullable = false, unique = true, length = 30)
    private String employeeNo;

    private String phone;
    private String department;
    private String position;

    @Column(nullable = false)
    private String role = "USER"; // 기본값 USER

    @Column(nullable = false)
    private String status = "ACTIVE";

    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}