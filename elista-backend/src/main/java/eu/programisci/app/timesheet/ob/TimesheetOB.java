package eu.programisci.app.timesheet.ob;

import eu.programisci.app.timesheet.enums.EWork;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "timesheet")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_timesheet_id")
public class TimesheetOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "workplace")
    private EWork workplace;

    @Column(name = "workDate")
    private Long workDate;

    @Column(name = "startDate")
    private Long startDate;

    @Column(name = "endDate")
    private Long endDate;

    @Column(name = "employeeId")
    private Long employeeId;


}
