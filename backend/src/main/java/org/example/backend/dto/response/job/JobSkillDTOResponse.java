package org.example.backend.dto.response.job;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.entity.child.job.Job;
import org.example.backend.entity.child.job.Skill;

@Getter
@Setter
@AllArgsConstructor
public class JobSkillDTOResponse {

    private Long id;
    private String jobName;
    private String skillName;

}
