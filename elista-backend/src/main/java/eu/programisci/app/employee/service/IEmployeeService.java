package eu.programisci.app.employee.service;

import eu.programisci.app.employee.dto.EmployeeDTO;
import eu.programisci.app.employee.dto.EmployeeLightDTO;

import java.util.List;

public interface IEmployeeService {

    EmployeeDTO findOne(Long id);

    List<EmployeeDTO> findAllForTable();

    void deleteOne(Long id);

    EmployeeDTO save(EmployeeDTO userDTO);

    List<String> findByIdContact(Long aEmployeeId);


    List<EmployeeDTO> init();

}
