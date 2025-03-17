package org.example.backend.entity.child.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.enums.StatusFreelancerJob;
import org.example.backend.enums.StatusJob;
import org.example.backend.enums.TypePayment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "job")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job extends AbstractEntity<Long> {
    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "scope")
    private String scope;

    @Column(name = "hour_work", precision = 10, scale = 2)
    private BigDecimal hourWork;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "job_opportunity")
    private Boolean jobOpportunity;

    @Column(name = "from_price", precision = 10, scale = 2)
    private BigDecimal fromPrice;

    @Column(name = "to_price", precision = 10, scale = 2)
    private BigDecimal toPrice;

    @Lob
    @Column(name = "type_price")
    private String typePrice;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING) // Sử dụng kiểu chuỗi cho enum
    @Column(name = "type_payment")
    private TypePayment typePayment; // Trường status sẽ lưu enum

    @Enumerated(EnumType.STRING) // Sử dụng kiểu chuỗi cho enum
    @Column(name = "status")
    private StatusJob status; // Trường status sẽ lưu enum

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<FreelancerJob> freelancerJobs;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<JobSkill> jobSkills;

    public int getQuantity() {
        return freelancerJobs != null ? freelancerJobs.size() : 0;
    }

}
