package eu.programisci.app.employee.service;

import eu.programisci.app.employee.converters.EmployeeConverter;
import eu.programisci.app.employee.dto.EmployeeDTO;
import eu.programisci.app.employee.dto.EmployeeLightDTO;
import eu.programisci.app.employee.enums.EPosition;
import eu.programisci.app.employee.ob.EmployeeOB;
import eu.programisci.app.employee.repository.IContactRepository;
import eu.programisci.app.employee.repository.IEmployeeRepository;
import eu.programisci.app.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        ob.setPosition(dto.getPosition());
        ob.setLastname(dto.getLastname());
        ob.setAvatarPath(dto.getAvatarPath());
        ob = employeeRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------

    @Override
    public List<String> findByIdContact(Long aEmployeeId) {
        return employeeRepository.findByIdContact(aEmployeeId);
    }

    @Override
    public List<EmployeeDTO> init() {
        List<EmployeeOB> pOBList = new ArrayList<>();
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Krzychu", "Stonoga", EPosition.FrontEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar2.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Stonoga", EPosition.FrontEndDeveloper, "../images/avatar3.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Krzychu", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Stonoga", "Rabczewski", EPosition.FrontEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar2.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Ewelina", "Maryś", EPosition.FrontEndDeveloper, "../images/avatar3.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Krzychu", "Stonoga", EPosition.BackEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.FrontEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Stonoga", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar2.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.FrontEndDeveloper, "../images/avatar3.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Krzychu", EPosition.FrontEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar2.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.FrontEndDeveloper, "../images/avatar3.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.FrontEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar2.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar3.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.FrontEndDeveloper, "../images/avatar.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar1.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar2.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar3.jpg")));
        pOBList.add(employeeConverter.dtoToOb(new EmployeeDTO(null, "Damian", "Rabczewski", EPosition.BackEndDeveloper, "../images/avatar1.jpg")));
        pOBList = employeeRepository.save(pOBList);
        return employeeConverter.obListToDtoList(pOBList);
    }

}
