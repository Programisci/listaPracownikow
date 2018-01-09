package eu.programisci.app.skill.ob;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

}
