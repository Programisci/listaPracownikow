package eu.programisci.app.employee.api;

import eu.programisci.app.employee.dto.EmployeeDTO;
import eu.programisci.app.employee.dto.EmployeeLightDTO;
import eu.programisci.app.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class EmployeeCustomRestController {
//
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<EmployeeDTO> init() {
        return employeeService.init();
    }

}
