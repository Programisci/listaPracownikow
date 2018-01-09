package eu.programisci.app.timesheet.dto;

import eu.programisci.app.timesheet.enums.EWork;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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

}
