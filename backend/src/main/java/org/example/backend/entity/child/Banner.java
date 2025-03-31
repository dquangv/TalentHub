package org.example.backend.entity.child;

import com.google.type.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "banner")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banner extends AbstractEntity<Long> {

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "status", nullable = false)
    private boolean status;
    @Column(name = "vendor", nullable = false)
    private String vendor;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "logo")
    private String logo;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;
}
