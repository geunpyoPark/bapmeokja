package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;


@Entity
@Table(name = "gps_logs")
@Getter @Setter @NoArgsConstructor
public class GpsLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_location_id")
    private WorkLocation workLocation;

    @Column(nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(precision = 8, scale = 2)
    private BigDecimal accuracy;

    @Column(name = "verified_yn", nullable = false)
    private boolean verifiedYn = false;

    private LocalDateTime verifiedAt;

    @Column(name = "action_type", nullable = false, length = 20)
    private String actionType; // CHECK_IN, CHECK_OUT

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}