package org.example.backend.entity.child;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.Job;
import org.example.backend.enums.ReportedJobStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportedJob extends AbstractEntity<Long> {


    @Column(name = "title", nullable = false)
    private String reasonFreelancer;
    @Column(name = "image", nullable = false)
    private String reasonAdmin;
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReportedJobStatus status;



    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Job job;
}
