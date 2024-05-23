package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.User;
import co.edu.icesiviajes.dto.UserDTO;
import co.edu.icesiviajes.mapper.UserMapper;
import co.edu.icesiviajes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDTO> findAll() {

        List<UserDTO> lst = mapper.toUserDTO(repository.findAll());

        return lst;
    }

    @Override
    public UserDTO findById(Integer id) throws Exception {
        try{
            User user = repository.findById(id).get();
            return mapper.toUserDTO(user);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public UserDTO save(UserDTO entity) throws Exception {

        if(repository.findById(entity.getId_user()).isEmpty()){
            User user = mapper.toUser(entity);
            return mapper.toUserDTO(repository.save(user));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public UserDTO update(UserDTO entity) throws Exception {

        if(repository.findById(entity.getId_user()).isPresent()){
            User user = mapper.toUser(entity);
            return mapper.toUserDTO(repository.save(user));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(UserDTO entity) throws Exception {

        if(repository.findById(entity.getId_user()).isPresent()){
            User user = mapper.toUser(entity);
            repository.delete(user);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(UserDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

}
