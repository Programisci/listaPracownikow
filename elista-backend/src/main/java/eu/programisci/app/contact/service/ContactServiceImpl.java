package eu.programisci.app.contact.service;

import eu.programisci.app.contact.converters.ContactConverter;
import eu.programisci.app.contact.dto.ContactDTO;
import eu.programisci.app.contact.ob.ContactOB;
import eu.programisci.app.contact.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private IContactRepository contactRepository;

    @Autowired
    private ContactConverter contactConverter;

    @Override
    public ContactDTO findOne(Long id) {
        ContactOB ob = contactRepository.findOne(id);
        ContactDTO dto = contactConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<ContactDTO> findAllForTable() {
        List<ContactOB> obList = contactRepository.findAll();
        List<ContactDTO> dtoList = contactConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        contactRepository.delete(id);
    }

    @Override
    public ContactDTO save(ContactDTO dto) {
        if (dto.getId() == null) {
            return contactConverter.obToDto(create(dto));
        } else {
            return contactConverter.obToDto(update(dto));
        }
    }

    private ContactOB create(ContactDTO dto) {
        ContactOB ob = contactConverter.dtoToOb(dto);
//        ob.setCreationDate(new Date());
        ob = contactRepository.save(ob);
        return ob;
    }

    private ContactOB update(ContactDTO dto) {
        ContactOB ob = contactRepository.findOne(dto.getId());
        ob.setContactType(dto.getContactType());
        ob.setContactValue(dto.getContactValue());
        ob.setEmployeeId(dto.getEmployeeId());
        ob = contactRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------

    @Override
    public List<ContactDTO> init() {
        List<ContactOB> pOBList = new ArrayList<>();
        pOBList.add(contactConverter.dtoToOb(new ContactDTO(null, "Skype", "sivy12_12", (long) 1)));
        pOBList.add(contactConverter.dtoToOb(new ContactDTO(null, "Skype", "sivy12_12", (long) 1)));
        pOBList.add(contactConverter.dtoToOb(new ContactDTO(null, "Skype", "sivy12_12", (long) 2)));
        pOBList.add(contactConverter.dtoToOb(new ContactDTO(null, "Skype", "sivy12_12", (long) 2)));
        pOBList.add(contactConverter.dtoToOb(new ContactDTO(null, "Skype", "sivy12_12", (long) 3)));
        pOBList = contactRepository.save(pOBList);
        return contactConverter.obListToDtoList(pOBList);
    }

}
