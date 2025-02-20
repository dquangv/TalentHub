package org.example.backend.entity.child.account.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.entity.child.job.Job;

import java.util.List;

@Table(name = "company")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company extends AbstractEntity<Long> {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_contact")
    private String phoneContact;

    @Column(name = "address")
    private String address;

    @Column(name = "industry")
    private String Industry;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
