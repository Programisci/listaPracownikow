package eu.programisci.app.project.service;

import eu.programisci.app.project.dto.ProjectDTO;

import java.util.List;

public interface IProjectService {

    ProjectDTO findOne(Long id);

    List<ProjectDTO> findAllForTable();

    void deleteOne(Long id);

    ProjectDTO save(ProjectDTO userDTO);


    List<ProjectDTO> init();

}
