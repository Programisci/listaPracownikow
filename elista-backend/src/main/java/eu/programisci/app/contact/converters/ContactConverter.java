package eu.programisci.app.contact.converters;

import eu.programisci.app.contact.dto.ContactDTO;
import eu.programisci.app.contact.ob.ContactOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactConverter {

    public ContactDTO obToDto(ContactOB in) {
        ContactDTO out = new ContactDTO();
        out.setId(in.getId());
        out.setContactType(in.getContactType());
        out.setContactValue(in.getContactValue());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }

    public ContactOB dtoToOb(ContactDTO in) {
        ContactOB out = new ContactOB();
        out.setId(in.getId());
        out.setContactType(in.getContactType());
        out.setContactValue(in.getContactValue());
        out.setEmployeeId(in.getEmployeeId());
        return out;
    }


    public List<ContactDTO> obListToDtoList(List<ContactOB> inList) {
        if (inList == null) {
            return null;
        }
        List<ContactDTO> outList = new ArrayList<>();
        for (ContactOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
