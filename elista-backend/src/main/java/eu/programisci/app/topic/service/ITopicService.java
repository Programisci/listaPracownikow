package eu.programisci.app.topic.service;

import eu.programisci.app.topic.dto.TopicDTO;

import java.util.List;

public interface ITopicService {

    TopicDTO findOne(Long id);

    List<TopicDTO> findAllForTable();

    void deleteOne(Long id);

    TopicDTO save(TopicDTO userDTO);


    List<TopicDTO> init();

}
