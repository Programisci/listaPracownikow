package eu.programisci.app.timesheet.api;

import eu.programisci.app.timesheet.dto.TimesheetDTO;
import eu.programisci.app.timesheet.service.ITimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class TimesheetCustomRestController {
//
    @Autowired
    private ITimesheetService timesheetService;

    @RequestMapping(value = "/initTimesheet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TimesheetDTO> init() {
        return timesheetService.init();
    }

}
