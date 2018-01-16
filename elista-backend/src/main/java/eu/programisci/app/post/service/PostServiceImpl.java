package eu.programisci.app.post.service;

import eu.programisci.app.post.converters.PostConverter;
import eu.programisci.app.post.dto.PostDTO;
import eu.programisci.app.post.ob.PostOB;
import eu.programisci.app.post.repository.IPostRepository;
import eu.programisci.app.post.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private PostConverter postConverter;

    @Override
    public PostDTO findOne(Long id) {
        PostOB ob = postRepository.findOne(id);
        PostDTO dto = postConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<PostDTO> findAllForTable() {
        List<PostOB> obList = postRepository.findAll();
        List<PostDTO> dtoList = postConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        postRepository.delete(id);
    }

    @Override
    public PostDTO save(PostDTO dto) {
        if (dto.getId() == null) {
            return postConverter.obToDto(create(dto));
        } else {
            return postConverter.obToDto(update(dto));
        }
    }

    private PostOB create(PostDTO dto) {
        PostOB ob = postConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = postRepository.save(ob);
        return ob;
    }

    private PostOB update(PostDTO dto) {
        PostOB ob = postRepository.findOne(dto.getId());
        ob.setMessage(dto.getMessage());
        ob.setEmployeeId(dto.getEmployeeId());
        ob = postRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------


    @Override
    public List<PostDTO> init() {
        List<PostOB> pOBList = new ArrayList<>();
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 2)));
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 3)));
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 4)));
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(postConverter.dtoToOb(new PostDTO(null, "bardzo długi tekst", (long) 0)));
        pOBList = postRepository.save(pOBList);
        return postConverter.obListToDtoList(pOBList);
    }

}
