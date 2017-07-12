package eu.programisci.app.project.converters;

import eu.programisci.app.project.dto.ProjectDTO;
import eu.programisci.app.project.ob.ProjectOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectConverter {

    public ProjectDTO obToDto(ProjectOB in) {
        ProjectDTO out = new ProjectDTO();
        out.setId(in.getId());
        out.setProjectName(in.getProjectName());
        out.setStatus(in.getStatus());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }

    public ProjectOB dtoToOb(ProjectDTO in) {
        ProjectOB out = new ProjectOB();
        out.setId(in.getId());
        out.setProjectName(in.getProjectName());
        out.setStatus(in.getStatus());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }


    public List<ProjectDTO> obListToDtoList(List<ProjectOB> inList) {
        if (inList == null) {
            return null;
        }
        List<ProjectDTO> outList = new ArrayList<>();
        for (ProjectOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
