package org.example.backend.entity.child.account.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.job.FreelancerJob;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "client_review")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientReview extends AbstractEntity<Long> {

    //change from on_time to rating, remember drop and create new database
    @Column(name = "rating")
    private Float rating;

    @Column(name = "note")
    private String note;


    /*@OneToMany(mappedBy = "clientReview" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<FreelancerJob> freelancerJobs;*/

}
