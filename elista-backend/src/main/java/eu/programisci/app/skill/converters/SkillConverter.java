package eu.programisci.app.skill.converters;

import eu.programisci.app.skill.dto.SkillDTO;
import eu.programisci.app.skill.ob.SkillOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillConverter {

    public SkillDTO obToDto(SkillOB in) {
        SkillDTO out = new SkillDTO();
        out.setId(in.getId());
        out.setSkillName(in.getSkillName());
        out.setDescription(in.getDescription());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }

    public SkillOB dtoToOb(SkillDTO in) {
        SkillOB out = new SkillOB();
        out.setId(in.getId());
        out.setSkillName(in.getSkillName());
        out.setDescription(in.getDescription());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }


    public List<SkillDTO> obListToDtoList(List<SkillOB> inList) {
        if (inList == null) {
            return null;
        }
        List<SkillDTO> outList = new ArrayList<>();
        for (SkillOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
