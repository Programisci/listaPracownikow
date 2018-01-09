package eu.programisci.app.skill.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDTO {

    private Long id;
    private String skillName;
    private String description;
    private Long employeeId;

public SkillDTO() {
    }

    public SkillDTO(Long aId, String aSkillName,String aDescription, Long aEmployeeId) {
        id = aId;
        skillName = aSkillName;
        description = aDescription;
        employeeId = aEmployeeId;
    }

}
