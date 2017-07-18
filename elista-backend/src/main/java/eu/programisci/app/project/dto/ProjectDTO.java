package eu.programisci.app.project.dto;
import eu.programisci.app.project.enums.EStatus;


public class ProjectDTO {

    private Long id;
    private String projectName;
    private EStatus status;
    private Long employeeId;

public ProjectDTO() {
    }

    public ProjectDTO(Long aId, String aProjectName, EStatus aStatus, Long aEmployeeId) {
        id = aId;
        projectName = aProjectName;
        status = aStatus;
        employeeId = aEmployeeId;
    }

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
