package eu.programisci.app.timesheet.dto;

import eu.programisci.app.timesheet.enums.EWork;

import java.util.Date;

public class TimesheetDTO {

    private Long id;
    private EWork workplace;
    private Long workDate;
    private Long startDate;
    private Long endDate;
    private Long employeeId;

    public TimesheetDTO() {
    }

    public TimesheetDTO(Long aId, EWork aWorkplace, Long aWorkDate, Long aStartDate, Long aEndDate, Long aEmployeeId) {
        id = aId;
        workplace = aWorkplace;
        workDate = aWorkDate;
        startDate = aStartDate;
        endDate = aEndDate;
        employeeId = aEmployeeId;
    }

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
