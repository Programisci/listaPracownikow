package eu.programisci.app.topic.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDTO {

    private Long id;
    private String message;
    private Long employeeId;

public TopicDTO() {
    }

    public TopicDTO(Long aId,String aMessage, Long aEmployeeId) {
        id = aId;
        message = aMessage;
        employeeId = aEmployeeId;
    }

}
