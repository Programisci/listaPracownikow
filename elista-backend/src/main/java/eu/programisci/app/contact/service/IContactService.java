package eu.programisci.app.contact.service;

import eu.programisci.app.contact.dto.ContactDTO;

import java.util.List;

public interface IContactService {

    ContactDTO findOne(Long id);

    List<ContactDTO> findAllForTable();

    void deleteOne(Long id);

    ContactDTO save(ContactDTO userDTO);

    List<ContactDTO> init();

}
