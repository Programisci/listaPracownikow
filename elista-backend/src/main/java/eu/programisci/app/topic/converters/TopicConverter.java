package eu.programisci.app.topic.converters;

import eu.programisci.app.topic.dto.TopicDTO;
import eu.programisci.app.topic.ob.TopicOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicConverter {

    public TopicDTO obToDto(TopicOB in) {
        TopicDTO out = new TopicDTO();
        out.setId(in.getId());
        out.setMessage(in.getMessage());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }

    public TopicOB dtoToOb(TopicDTO in) {
        TopicOB out = new TopicOB();
        out.setId(in.getId());
        out.setMessage(in.getMessage());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }


    public List<TopicDTO> obListToDtoList(List<TopicOB> inList) {
        if (inList == null) {
            return null;
        }
        List<TopicDTO> outList = new ArrayList<>();
        for (TopicOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
