package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;


@Entity
@Table(name = "attendance_records")
@Getter @Setter @NoArgsConstructor
public class AttendanceRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 외래키 연결

    @Column(name = "work_date", nullable = false)
    private LocalDate workDate;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    // GPS 로그 및 사진 로그와의 연관관계는 추후 필요시 추가 가능
    private Long checkInGpsLogId;
    private Long checkOutGpsLogId;
    private Long checkInPhotoId;
    private Long checkOutPhotoId;

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, NORMAL, LATE 등

    private String memo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}