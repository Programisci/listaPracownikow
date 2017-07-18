package eu.programisci.app.project.service;

import eu.programisci.app.project.converters.ProjectConverter;
import eu.programisci.app.project.dto.ProjectDTO;
import eu.programisci.app.project.enums.EStatus;
import eu.programisci.app.project.ob.ProjectOB;
import eu.programisci.app.project.repository.IProjectRepository;
import eu.programisci.app.project.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private ProjectConverter projectConverter;

    @Override
    public ProjectDTO findOne(Long id) {
        ProjectOB ob = projectRepository.findOne(id);
        ProjectDTO dto = projectConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<ProjectDTO> findAllForTable() {
        List<ProjectOB> obList = projectRepository.findAll();
        List<ProjectDTO> dtoList = projectConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        projectRepository.delete(id);
    }

    @Override
    public ProjectDTO save(ProjectDTO dto) {
        if (dto.getId() == null) {
            return projectConverter.obToDto(create(dto));
        } else {
            return projectConverter.obToDto(update(dto));
        }
    }

    private ProjectOB create(ProjectDTO dto) {
        ProjectOB ob = projectConverter.dtoToOb(dto);
//        ob.setCreationDate(new Date());
        ob = projectRepository.save(ob);
        return ob;
    }

    private ProjectOB update(ProjectDTO dto) {
        ProjectOB ob = projectRepository.findOne(dto.getId());
        ob.setProjectName(dto.getProjectName());
        ob.setStatus(dto.getStatus());
        ob.setEmployeeId(dto.getEmployeeId());
        ob = projectRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------


    @Override
    public List<ProjectDTO> init() {
        List<ProjectOB> pOBList = new ArrayList<>();
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt Elista", EStatus.CLOSURE, (long) 1)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt Elista", EStatus.MAINTENANCE, (long) 1)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt Elista", EStatus.CONCEPTUAL_FRAMEWORK, (long) 1)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt Elista", EStatus.DEVELOPMENT, (long) 1)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt kleszcza", EStatus.ROLLOUT, (long) 1)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt kleszcza", EStatus.DEVELOPMENT, (long) 1)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt kleszcza", EStatus.ROLLOUT, (long) 2)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt kleszcza", EStatus.CLOSURE, (long) 2)));
        pOBList.add(projectConverter.dtoToOb(new ProjectDTO(null, "Projekt kleszcza", EStatus.MAINTENANCE, (long) 1)));
        pOBList = projectRepository.save(pOBList);
        return projectConverter.obListToDtoList(pOBList);
    }

}
