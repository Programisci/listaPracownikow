package eu.programisci.app.timesheet.converters;

import eu.programisci.app.timesheet.dto.TimesheetDTO;
import eu.programisci.app.timesheet.ob.TimesheetOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetConverter {

    public TimesheetDTO obToDto(TimesheetOB in) {
        TimesheetDTO out = new TimesheetDTO();
        out.setId(in.getId());
        out.setWorkplace(in.getWorkplace());
        out.setWorkDate(in.getWorkDate());
        out.setStartDate(in.getStartDate());
        out.setEndDate(in.getEndDate());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }

    public TimesheetOB dtoToOb(TimesheetDTO in) {
        TimesheetOB out = new TimesheetOB();
        out.setId(in.getId());
        out.setWorkplace(in.getWorkplace());
        out.setWorkDate(in.getWorkDate());
        out.setStartDate(in.getStartDate());
        out.setEndDate(in.getEndDate());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }


    public List<TimesheetDTO> obListToDtoList(List<TimesheetOB> inList) {
        if (inList == null) {
            return null;
        }
        List<TimesheetDTO> outList = new ArrayList<>();
        for (TimesheetOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
