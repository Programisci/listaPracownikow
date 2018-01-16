package eu.programisci.app.post.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

    private Long id;
    private String message;
    private Long employeeId;

public PostDTO() {
    }

    public PostDTO(Long aId, String aMessage, Long aEmployeeId) {
        id = aId;
        message = aMessage;
        employeeId = aEmployeeId;
    }

}
