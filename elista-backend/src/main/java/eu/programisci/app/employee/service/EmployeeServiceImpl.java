package eu.programisci.app.employee.service;

import eu.programisci.app.employee.converters.EmployeeConverter;
import eu.programisci.app.employee.dto.EmployeeDTO;
import eu.programisci.app.employee.enums.EPosition;
import eu.programisci.app.employee.enums.ERole;
import eu.programisci.app.employee.ob.EmployeeOB;
import eu.programisci.app.employee.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public EmployeeDTO findOne(Long id) {
        EmployeeOB ob = employeeRepository.findOne(id);
        EmployeeDTO dto = employeeConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<EmployeeDTO> findAllForTable() {
        List<EmployeeOB> obList = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = employeeConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO dto) {
        if (dto.getId() == null) {
            return employeeConverter.obToDto(create(dto));
        } else {
            return employeeConverter.obToDto(update(dto));
        }
    }

    private EmployeeOB create(EmployeeDTO dto) {
        EmployeeOB ob = employeeConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = employeeRepository.save(ob);
        return ob;
    }

    private EmployeeOB update(EmployeeDTO dto) {
        EmployeeOB ob = employeeRepository.findOne(dto.getId());
        ob.setName(dto.getName());
        ob.setLastname(dto.getLastname());
        ob.setPosition(dto.getPosition());
        ob.setAvatarPath(dto.getAvatarPath());
        ob.setRole(dto.getRole());
        ob.setCashPerHour(dto.getCashPerHour());
        ob.setPasswd(dto.getPasswd());
        ob.setLogin(dto.getLogin());
        ob = employeeRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------


    @Override
    public List<EmployeeDTO> init() {
        List<EmployeeOB> pOBList = new ArrayList<>();
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", "Backend Developer", "../images/avatar.jpg", ERole.Admin, 140, "admin", "admin")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Krzychu", "Stonoga", "Frontend Developer", "../images/avatar1.jpg", ERole.User, 14, "user", "user1")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", "Backend Developer", "../images/avatar2.jpg", ERole.User, 14, "user", "user2")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Stonoga", "Frontend Developer", "../images/avatar3.jpg", ERole.User, 14, "user", "user3")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Krzychu", "Rabczewski", "Backend Developer", "../images/avatar.jpg", ERole.User, 14, "user", "user4")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Stonoga", "Rabczewski", "Frontend Developer", "../images/avatar1.jpg", ERole.User, 14, "user", "user5")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", "Backend Developer", "../images/avatar2.jpg", ERole.User, 14, "user", "user6")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Ewelina", "Maryś", "Frontend Developer", "../images/avatar3.jpg", ERole.User, 14, "user", "user7")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Krzychu", "Stonoga", "Backend Developer", "../images/avatar1.jpg", ERole.User, 14, "user", "user8")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", "Frontend Developer", "../images/avatar1.jpg", ERole.User, 14, "user", "user9")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Stonoga", "Rabczewski", "Backend Developer", "../images/avatar2.jpg", ERole.User, 14, "user", "user10")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", "Frontend Developer", "../images/avatar3.jpg", ERole.User, 14, "user", "user11")));
        pOBList = employeeRepository.save(pOBList);
        return employeeConverter.obListToDtoList(pOBList);
    }

}
