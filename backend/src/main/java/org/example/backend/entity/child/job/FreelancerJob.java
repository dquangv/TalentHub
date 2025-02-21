package org.example.backend.entity.child.job;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.client.ClientReview;
import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.entity.child.account.freelancer.FreelancerReview;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.enums.StatusFreelancerJob;

@Table(name = "freelancer_job")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerJob extends AbstractEntity<Long> {

    @Column(name = "is_saved")
    private Boolean isSaved;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusFreelancerJob status;

    @Size(max = 255)
    @Column(name = "cv")
    private String cv;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @OneToOne
    @JoinColumn(name = "freelancer_review_id")
    private FreelancerReview freelancerReview;

    @OneToOne
    @JoinColumn(name = "client_review_id")
    private ClientReview clientReview;

    /*@ManyToOne
    @JoinColumn(name = "CV_id")*/

    @OneToOne
    @JoinColumn(name = "cv_id")
    private CV CV;
}
