package eu.programisci.app.post.service;

import eu.programisci.app.post.dto.PostDTO;

import java.util.List;

public interface IPostService {

    PostDTO findOne(Long id);

    List<PostDTO> findAllForTable();

    void deleteOne(Long id);

    PostDTO save(PostDTO userDTO);


    List<PostDTO> init();

}
