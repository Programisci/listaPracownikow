package eu.programisci.app.employee.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeLightDTO {

    private Long id;
    private String name;
    private String lastname;
    private String avatarPath;

    public EmployeeLightDTO() {
    }

    public EmployeeLightDTO(Long aId, String aName, String aLastname, String aAvatarPath) {
        id = aId;
        name = aName;
        lastname = aLastname;
        avatarPath = aAvatarPath;
    }
}
