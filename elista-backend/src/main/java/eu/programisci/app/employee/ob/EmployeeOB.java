package eu.programisci.app.employee.ob;

import eu.programisci.app.employee.enums.EPosition;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_employee_id")
public class EmployeeOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private Date creationDate;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private EPosition position;

    @Column(name = "avatarPath")
    private String avatarPath;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date aCreationDate) {
        creationDate = aCreationDate;
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
