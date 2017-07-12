package eu.programisci.app.project.ob;

import eu.programisci.app.project.enums.EStatus;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String aProjectName) {
        projectName = aProjectName;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus aStatus) {
        status = aStatus;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long aEmployeeId) {
        employeeId = aEmployeeId;
    }

}
