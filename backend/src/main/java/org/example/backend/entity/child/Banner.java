package org.example.backend.entity.child;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
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
    private String status;
    @Column(name = "vendor", nullable = false)
    private String vendor;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "start_time", nullable = false)
    private LocalDate startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDate endTime;
}
