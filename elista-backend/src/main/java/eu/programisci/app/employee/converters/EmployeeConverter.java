package eu.programisci.app.employee.converters;

import eu.programisci.app.employee.dto.EmployeeDTO;
import eu.programisci.app.employee.ob.EmployeeOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeConverter {

    public EmployeeDTO obToDto(EmployeeOB in) {
        EmployeeDTO out = new EmployeeDTO();
        out.setId(in.getId());
        out.setName(in.getName());
        out.setPosition(in.getPosition());
        out.setLastname(in.getLastname());
        out.setAvatarPath(in.getAvatarPath());
        out.setRole(in.getRole());
        out.setCashPerHour(in.getCashPerHour());
        out.setPasswd(in.getPasswd());
        out.setLogin(in.getLogin());
        return out;
    }

    public EmployeeOB dtoToOb(EmployeeDTO in) {
        EmployeeOB out = new EmployeeOB();
        out.setId(in.getId());
        out.setName(in.getName());
        out.setPosition(in.getPosition());
        out.setLastname(in.getLastname());
        out.setAvatarPath(in.getAvatarPath());
        out.setRole(in.getRole());
        out.setCashPerHour(in.getCashPerHour());
        out.setPasswd(in.getPasswd());
        out.setLogin(in.getLogin());
        return out;
    }


    public List<EmployeeDTO> obListToDtoList(List<EmployeeOB> inList) {
        if (inList == null) {
            return null;
        }
        List<EmployeeDTO> outList = new ArrayList<>();
        for (EmployeeOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
