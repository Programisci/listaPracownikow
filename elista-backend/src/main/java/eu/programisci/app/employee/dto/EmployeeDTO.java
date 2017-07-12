package eu.programisci.app.employee.dto;

import eu.programisci.app.employee.enums.EPosition;

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

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String aLastname) {
        lastname = aLastname;
    }

    public EPosition getPosition() {
        return position;
    }

    public void setPosition(EPosition aPosition) {
        position = aPosition;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String aAvatarPath) {
        avatarPath = aAvatarPath;
    }

}
