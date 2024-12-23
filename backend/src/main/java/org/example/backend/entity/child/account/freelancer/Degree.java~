package org.example.backend.entity.child.account.freelancer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;

import java.util.List;

@Table(name = "degree")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Degree extends AbstractEntity<Long> {

    private String degreeTitle;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Education> educations;
}
