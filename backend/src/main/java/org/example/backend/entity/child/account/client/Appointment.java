package org.example.backend.entity.child.account.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.type.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.job.FreelancerJob;

import java.time.LocalDateTime;

@Table(name = "appointments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends AbstractEntity<Long> {

    @Column(name = "topic")
    private String topic;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "freelancer_job_id")
    private FreelancerJob freelancerJob;
}
