package eu.programisci.app.project.api;

import eu.programisci.app.project.dto.ProjectDTO;
import eu.programisci.app.project.enums.EStatus;
import eu.programisci.app.project.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee/project")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class ProjectRestController {

    @Autowired
    private IProjectService projectService;

    private boolean alreadyExecuted = false;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProjectDTO findOne(@RequestParam("id") Long aId) {
        return projectService.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ProjectDTO> findAll() {
        return projectService.findAllForTable();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        projectService.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProjectDTO save(@RequestBody ProjectDTO aProjectDTO) {
        return projectService.save(aProjectDTO);
    }

    @RequestMapping(value = "/getStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EStatus[] getPosition() {
        return EStatus.values();
    }


}
