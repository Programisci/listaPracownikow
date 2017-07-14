package eu.programisci.app.skill.ob;

import javax.persistence.*;

@Entity
@Table(name = "skill")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_skill_id")
public class SkillOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "skillName")
    private String skillName;

    @Column(name = "description")
    private String description;


    @Column(name = "employeeId")
    private Long employeeId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
//    private EmployeeOB employeee;

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
