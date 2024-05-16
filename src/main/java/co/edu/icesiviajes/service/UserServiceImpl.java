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
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {

        List<UserDTO> lstCliente = userMapper.toUserDTO(userRepository.findAll());

        return lstCliente;
    }

    @Override
    public UserDTO findById(Integer id) throws Exception {
        try{
            User user = userRepository.findById(id).get();
            return userMapper.toUserDTO(user);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public UserDTO save(UserDTO entity) throws Exception {

        User user = userMapper.toUser(entity);

        if(userRepository.findById(user.getId_user()).isEmpty()){
            return userMapper.toUserDTO(userRepository.save(user));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public UserDTO update(UserDTO entity) throws Exception {

        User user = userMapper.toUser(entity);

        if(userRepository.findById(user.getId_user()).isPresent()){
            return userMapper.toUserDTO(userRepository.save(user));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(UserDTO entity) throws Exception {

        User user = userMapper.toUser(entity);

        if(userRepository.findById(user.getId_user()).isPresent()){
            userRepository.delete(user);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            User user = userRepository.findById(id).get();
            userRepository.deleteById(user.getId_user());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(UserDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return userRepository.count();

    }

}
