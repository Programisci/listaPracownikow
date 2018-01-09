package eu.programisci.app.employee.dto;

import eu.programisci.app.employee.enums.EPosition;
import eu.programisci.app.employee.enums.ERole;
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
    private ERole role;
    private double cashPerHour;
    private String passwd;
    private String login;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long aId, String aName, String aLastname, EPosition aPosition, String aAvatarPath, ERole aRole,
                       double aCashPerHour, String aPasswd, String aLogin) {
        id = aId;
        name = aName;
        lastname = aLastname;
        position = aPosition;
        avatarPath = aAvatarPath;
        role = aRole;
        cashPerHour = aCashPerHour;
        passwd = aPasswd;
        login = aLogin;
    }

}
