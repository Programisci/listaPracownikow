package eu.programisci.app.employee.ob;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_contact_id")
public class ContactOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "contactValue")
    private String contactValue;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String aContactValue) {
        contactValue = aContactValue;
    }
}
