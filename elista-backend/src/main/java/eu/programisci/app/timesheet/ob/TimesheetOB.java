package eu.programisci.app.timesheet.ob;

import eu.programisci.app.timesheet.enums.EWork;

import javax.persistence.*;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public EWork getWorkplace() {
        return workplace;
    }

    public void setWorkplace(EWork aWorkplace) {
        workplace = aWorkplace;
    }

    public Long getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Long aWorkDate) {
        workDate = aWorkDate;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long aStartDate) {
        startDate = aStartDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long aEndDate) {
        endDate = aEndDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long aEmployeeId) {
        employeeId = aEmployeeId;
    }

}
