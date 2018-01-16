package eu.programisci.app.post.converters;

import eu.programisci.app.post.dto.PostDTO;
import eu.programisci.app.post.ob.PostOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostConverter {

    public PostDTO obToDto(PostOB in) {
        PostDTO out = new PostDTO();
        out.setId(in.getId());
        out.setMessage(in.getMessage());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }

    public PostOB dtoToOb(PostDTO in) {
        PostOB out = new PostOB();
        out.setId(in.getId());
        out.setMessage(in.getMessage());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }


    public List<PostDTO> obListToDtoList(List<PostOB> inList) {
        if (inList == null) {
            return null;
        }
        List<PostDTO> outList = new ArrayList<>();
        for (PostOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
