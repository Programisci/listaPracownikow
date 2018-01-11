package eu.programisci.app.timesheet.service;

import eu.programisci.app.timesheet.converters.TimesheetConverter;
import eu.programisci.app.timesheet.dto.TimesheetDTO;
import eu.programisci.app.timesheet.enums.EWork;
import eu.programisci.app.timesheet.ob.TimesheetOB;
import eu.programisci.app.timesheet.repository.ITimesheetRepository;
import eu.programisci.app.timesheet.service.ITimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TimesheetServiceImpl implements ITimesheetService {

    @Autowired
    private ITimesheetRepository timesheetRepository;

    @Autowired
    private TimesheetConverter timesheetConverter;

    @Override
    public TimesheetDTO findOne(Long id) {
        TimesheetOB ob = timesheetRepository.findOne(id);
        TimesheetDTO dto = timesheetConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<TimesheetDTO> findAllForTable() {
        List<TimesheetOB> obList = timesheetRepository.findAll();
        List<TimesheetDTO> dtoList = timesheetConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        timesheetRepository.delete(id);
    }

    @Override
    public TimesheetDTO save(TimesheetDTO dto) {
        if (dto.getId() == null) {
            return timesheetConverter.obToDto(create(dto));
        } else {
            return timesheetConverter.obToDto(update(dto));
        }
    }

    private TimesheetOB create(TimesheetDTO dto) {
        TimesheetOB ob = timesheetConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = timesheetRepository.save(ob);
        return ob;
    }

    private TimesheetOB update(TimesheetDTO dto) {
        TimesheetOB ob = timesheetRepository.findOne(dto.getId());
        ob.setWorkplace(dto.getWorkplace());
        ob.setWorkDate(dto.getWorkDate());
        ob.setStartDate(dto.getStartDate());
        ob.setEndDate(dto.getEndDate());
        ob.setEmployeeId(dto.getEmployeeId());
        ob = timesheetRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------


    @Override
    public List<TimesheetDTO> init() {
        List<TimesheetOB> pOBList = new ArrayList<>();
        pOBList.add(timesheetConverter.dtoToOb(new TimesheetDTO(null, EWork.Biuro, 1500295560000L, 1500295580000L,1500295580000L, (long) 1)));
        pOBList.add(timesheetConverter.dtoToOb(new TimesheetDTO(null, EWork.Biuro, 1500295560000L, 1500295580000L,1500295580000L, (long) 1)));
        pOBList.add(timesheetConverter.dtoToOb(new TimesheetDTO(null, EWork.Biuro, 1500295560000L, 1500295590000L,1500295590000L, (long) 1)));
        pOBList.add(timesheetConverter.dtoToOb(new TimesheetDTO(null, EWork.Biuro, 1500295560000L, 1500295590000L,1500295590000L, (long) 2)));
        pOBList = timesheetRepository.save(pOBList);
        return timesheetConverter.obListToDtoList(pOBList);
    }

}
