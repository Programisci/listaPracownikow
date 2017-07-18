package eu.programisci.app.skill.dto;


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

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String aSkillName) {
        skillName = aSkillName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long aEmployeeId) {
        employeeId = aEmployeeId;
    }

}
