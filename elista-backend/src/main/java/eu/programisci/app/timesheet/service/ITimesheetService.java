package eu.programisci.app.timesheet.service;

import eu.programisci.app.timesheet.dto.TimesheetDTO;

import java.util.List;

public interface ITimesheetService {

    TimesheetDTO findOne(Long id);

    List<TimesheetDTO> findAllForTable();

    void deleteOne(Long id);

    TimesheetDTO save(TimesheetDTO userDTO);


    List<TimesheetDTO> init();

}
