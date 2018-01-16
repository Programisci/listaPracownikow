package eu.programisci.app.employee.ob;

import eu.programisci.app.employee.enums.ERole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
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

    @Column(name = "position")
    private String position;

    @Column(name = "avatarPath")
    private String avatarPath;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role;

    @Column(name = "cashPerHour")
    private double cashPerHour;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "login")
    private String login;

}
