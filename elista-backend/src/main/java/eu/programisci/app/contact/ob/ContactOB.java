package eu.programisci.app.contact.ob;

import eu.programisci.app.employee.ob.EmployeeOB;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "contact")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_contact_id")
public class ContactOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "contactType")
    private String contactType;

    @Column(name = "contactValue")
    private String contactValue;


    @Column(name = "employeeId")
    private Long employeeId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
//    private EmployeeOB employeee;

}
