package eu.programisci.app.employee.dto;


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

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String aAvatarPath) {
        avatarPath = aAvatarPath;
    }
}
