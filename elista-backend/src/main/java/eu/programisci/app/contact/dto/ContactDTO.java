package eu.programisci.app.contact.dto;


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

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String aContactType) {
        contactType = aContactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String aContactValue) {
        contactValue = aContactValue;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long aEmployeeId) {
        employeeId = aEmployeeId;
    }

}
