package eu.programisci.app.topic.service;

import eu.programisci.app.topic.converters.TopicConverter;
import eu.programisci.app.topic.dto.TopicDTO;
import eu.programisci.app.topic.ob.TopicOB;
import eu.programisci.app.topic.repository.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private ITopicRepository topicRepository;

    @Autowired
    private TopicConverter topicConverter;

    @Override
    public TopicDTO findOne(Long id) {
        TopicOB ob = topicRepository.findOne(id);
        TopicDTO dto = topicConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<TopicDTO> findAllForTable() {
        List<TopicOB> obList = topicRepository.findAll();
        List<TopicDTO> dtoList = topicConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        topicRepository.delete(id);
    }

    @Override
    public TopicDTO save(TopicDTO dto) {
        if (dto.getId() == null) {
            return topicConverter.obToDto(create(dto));
        } else {
            return topicConverter.obToDto(update(dto));
        }
    }

    private TopicOB create(TopicDTO dto) {
        TopicOB ob = topicConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = topicRepository.save(ob);
        return ob;
    }

    private TopicOB update(TopicDTO dto) {
        TopicOB ob = topicRepository.findOne(dto.getId());
        ob.setMessage(dto.getMessage());
        ob.setEmployeeId(dto.getEmployeeId());
        ob = topicRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------


    @Override
    public List<TopicDTO> init() {
        List<TopicOB> pOBList = new ArrayList<>();
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 2)));
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 3)));
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 4)));
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 1)));
        pOBList.add(topicConverter.dtoToOb(new TopicDTO(null, "bardzo długi tekst", (long) 0)));
        pOBList = topicRepository.save(pOBList);
        return topicConverter.obListToDtoList(pOBList);
    }

}
