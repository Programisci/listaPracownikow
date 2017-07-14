package eu.programisci.app.skill.api;

import eu.programisci.app.skill.dto.SkillDTO;
import eu.programisci.app.skill.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee/skill")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class SkillRestController {

    @Autowired
    private ISkillService skillService;

    private boolean alreadyExecuted = false;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SkillDTO findOne(@RequestParam("id") Long aId) {
        return skillService.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<SkillDTO> findAll() {
        return skillService.findAllForTable();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        skillService.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SkillDTO save(@RequestBody SkillDTO aSkillDTO) {
        return skillService.save(aSkillDTO);
    }


}
