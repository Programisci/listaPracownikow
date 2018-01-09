package eu.programisci.app.contact.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {

    private Long id;
    private String contactType;
    private String contactValue;
    private Long employeeId;

    public ContactDTO() {
    }

    public ContactDTO(Long aId, String aContactType, String aContactValue, Long aEmployeeId) {
        id = aId;
        contactType = aContactType;
        contactValue = aContactValue;
        employeeId = aEmployeeId;
    }


}
