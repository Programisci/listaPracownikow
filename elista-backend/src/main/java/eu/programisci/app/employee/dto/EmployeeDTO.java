package eu.programisci.app.employee.dto;

import eu.programisci.app.employee.enums.EPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;
    private String name;
    private String lastname;
    private EPosition position;
    private String avatarPath;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long aId, String aName, String aLastname, EPosition aPosition, String aAvatarPath) {
        id = aId;
        name = aName;
        lastname = aLastname;
        position = aPosition;
        avatarPath = aAvatarPath;
    }

}
