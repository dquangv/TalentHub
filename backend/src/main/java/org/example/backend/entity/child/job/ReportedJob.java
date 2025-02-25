package org.example.backend.entity.child.job;

import com.google.type.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.freelancer.Freelancer;

@Entity
@Table(name = "reported_jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportedJob extends AbstractEntity<Long> {

    @Column(name = "reason_freelancer")
    private String reasonFreelancer;

    @Column(name = "reported_at")
    private DateTime reportedAt;

    @Column(name = "reason_admin")
    private String reasonAdmin;

    @Column(name = "update_at")
    private DateTime updateAt;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
}
