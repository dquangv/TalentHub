package org.example.backend.entity.child.account.freelancer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.job.FreelancerJob;

import java.util.List;

@Table(name = "cv")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CV extends AbstractEntity<Long> {

    @Column(name = "path")
    private String path;

    @Column(name = "name_cv")
    private String nameCV;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    /*@OneToMany(mappedBy = "CV", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<FreelancerJob> freelancerJobs;*/
}
