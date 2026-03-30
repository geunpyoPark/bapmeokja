package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;


@Entity
@Table(name = "work_locations")
@Getter @Setter @NoArgsConstructor
public class WorkLocation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String address;

    @Column(nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude; // DECIMAL(10,7) 반영

    @Column(nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "allowed_radius_m", nullable = false)
    private Integer allowedRadiusM;

    @Column(name = "active_yn", nullable = false)
    private boolean activeYn = true;
}