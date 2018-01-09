package eu.programisci.app.project.dto;
import eu.programisci.app.project.enums.EStatus;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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

}
