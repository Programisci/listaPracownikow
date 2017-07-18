package eu.programisci.app.skill.service;

import eu.programisci.app.skill.dto.SkillDTO;

import java.util.List;

public interface ISkillService {

    SkillDTO findOne(Long id);

    List<SkillDTO> findAllForTable();

    void deleteOne(Long id);

    SkillDTO save(SkillDTO userDTO);


    List<SkillDTO> init();

}
