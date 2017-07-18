package eu.programisci.app.skill.service;

import eu.programisci.app.skill.converters.SkillConverter;
import eu.programisci.app.skill.dto.SkillDTO;
import eu.programisci.app.skill.ob.SkillOB;
import eu.programisci.app.skill.repository.ISkillRepository;
import eu.programisci.app.skill.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements ISkillService {

    @Autowired
    private ISkillRepository skillRepository;

    @Autowired
    private SkillConverter skillConverter;

    @Override
    public SkillDTO findOne(Long id) {
        SkillOB ob = skillRepository.findOne(id);
        SkillDTO dto = skillConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<SkillDTO> findAllForTable() {
        List<SkillOB> obList = skillRepository.findAll();
        List<SkillDTO> dtoList = skillConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        skillRepository.delete(id);
    }

    @Override
    public SkillDTO save(SkillDTO dto) {
        if (dto.getId() == null) {
            return skillConverter.obToDto(create(dto));
        } else {
            return skillConverter.obToDto(update(dto));
        }
    }

    private SkillOB create(SkillDTO dto) {
        SkillOB ob = skillConverter.dtoToOb(dto);
//        ob.setCreationDate(new Date());
        ob = skillRepository.save(ob);
        return ob;
    }

    private SkillOB update(SkillDTO dto) {
        SkillOB ob = skillRepository.findOne(dto.getId());
        ob.setSkillName(dto.getSkillName());
        ob.setDescription(dto.getDescription());
        ob.setEmployeeId(dto.getEmployeeId());
        ob = skillRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------


    @Override
    public List<SkillDTO> init() {
        List<SkillOB> pOBList = new ArrayList<>();
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Java", "sredni", (long) 1)));
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Angular", "podstawowy", (long) 1)));
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Motoryzacja", "motocykle", (long) 1)));
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Wódka", "pasja", (long) 1)));
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Angular", "sredni", (long) 2)));
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Motoryzacja", "sredni", (long) 2)));
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Angular", "sredni", (long) 2)));
        pOBList.add(skillConverter.dtoToOb(new SkillDTO(null, "Angular", "sredni", (long) 2)));
        pOBList = skillRepository.save(pOBList);
        return skillConverter.obListToDtoList(pOBList);
    }

}
