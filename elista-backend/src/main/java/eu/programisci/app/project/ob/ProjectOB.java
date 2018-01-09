package eu.programisci.app.project.ob;

import eu.programisci.app.project.enums.EStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "project")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_project_id")
public class ProjectOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "projectName")
    private String projectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EStatus status;

    @Column(name = "employeeId")
    private Long employeeId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
//    private EmployeeOB employeee;

}
