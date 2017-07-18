package eu.programisci.app.timesheet.api;

import eu.programisci.app.timesheet.dto.TimesheetDTO;
import eu.programisci.app.timesheet.enums.EWork;
import eu.programisci.app.timesheet.service.ITimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee/timesheet")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class TimesheetRestController {

    @Autowired
    private ITimesheetService timesheetService;

    private boolean alreadyExecuted = false;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TimesheetDTO findOne(@RequestParam("id") Long aId) {
        return timesheetService.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TimesheetDTO> findAll() {
        return timesheetService.findAllForTable();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        timesheetService.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TimesheetDTO save(@RequestBody TimesheetDTO aTimesheetDTO) {
        return timesheetService.save(aTimesheetDTO);
    }

    @RequestMapping(value = "/getWorkplace", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EWork[] getPosition() {
        return EWork.values();
    }


}
