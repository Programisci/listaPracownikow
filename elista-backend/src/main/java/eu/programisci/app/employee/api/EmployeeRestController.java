package eu.programisci.app.employee.api;

import eu.programisci.app.employee.dto.EmployeeDTO;
import eu.programisci.app.employee.enums.EPosition;
import eu.programisci.app.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    private boolean alreadyExecuted = false;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EmployeeDTO findOne(@RequestParam("id") Long aId) {
        return employeeService.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<EmployeeDTO> findAll() {
//        if (!alreadyExecuted){
//            employeeService.init();
//            alreadyExecuted = true;
//        }
        return employeeService.findAllForTable();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        employeeService.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EmployeeDTO save(@RequestBody EmployeeDTO aEmployeeDTO) {
        return employeeService.save(aEmployeeDTO);
    }

    @RequestMapping(value = "/getPosition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EPosition[] getPosition() {
        return EPosition.values();
    }

    @RequestMapping(value = "/findByIdContact", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> findByIdContact(@RequestParam("employeeId") Long aEmployeeId) {
        return employeeService.findByIdContact(aEmployeeId);
    }
}