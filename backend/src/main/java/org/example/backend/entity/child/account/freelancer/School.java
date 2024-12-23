package org.example.backend.entity.child.account.freelancer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;

import java.util.List;

@Table(name = "school")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School extends AbstractEntity<Long> {

    @Column(name = "school_name")
    private String schoolName;

    /*@JsonIgnore
    @OneToMany(mappedBy = "school" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations;*/
}
