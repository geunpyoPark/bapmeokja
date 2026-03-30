package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;

// 여기서부터 @Entity 코드가 시작됩니다...

@Entity
@Table(name = "notices")
@Getter @Setter @NoArgsConstructor
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_user_id", nullable = false)
    private User writer;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private boolean isImportant = false;
    private boolean isVisible = true;
    private int viewCount = 0;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}