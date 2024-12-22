package org.example.backend.entity.child;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;

import java.util.List;

@Table(name = "skill")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill extends AbstractEntity<Long> {

    @Column(name = "skill_name")
    private String skillName;

    @OneToMany(mappedBy = "skill")
    @JsonIgnore
    private List<FreelancerSkill> freelancerSkills;
}
