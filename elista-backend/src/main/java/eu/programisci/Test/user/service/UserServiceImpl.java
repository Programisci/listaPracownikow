package eu.programisci.Test.user.service;

import eu.programisci.Test.user.converters.UserConverter;
import eu.programisci.Test.user.dto.UserDTO;
import eu.programisci.Test.user.dto.UserForTableDTO;
import eu.programisci.Test.user.ob.UserOB;
import eu.programisci.Test.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO findOne(Long id) {
        UserOB ob = userRepository.findOne(id);
        UserDTO dto = userConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<UserForTableDTO> findAllForTable() {
        List<UserOB> obList = userRepository.findAll();
        List<UserForTableDTO> dtoList = userConverter.userObToUserForTable(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDTO save(UserDTO dto) {
        if (dto.getId() == null) {
            return userConverter.obToDto(create(dto));
        } else {
            return userConverter.obToDto(update(dto));
        }
    }

    private UserOB create(UserDTO dto) {
        UserOB ob = userConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = userRepository.save(ob);
        return ob;
    }

    private UserOB update(UserDTO dto) {
        UserOB ob = userRepository.findOne(dto.getId());
        ob.setLogin(dto.getLogin());
        ob.setPassword(dto.getPassword());
        ob.setEmail(dto.getEmail());
        ob.setName(dto.getName());
        ob.setLastname(dto.getLastname());
        ob = userRepository.save(ob);
        return ob;
    }
}
