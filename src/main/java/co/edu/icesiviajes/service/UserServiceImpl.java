package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.User;
import co.edu.icesiviajes.dto.ClientDTO;
import co.edu.icesiviajes.dto.LoginDTO;
import co.edu.icesiviajes.dto.UserDTO;
import co.edu.icesiviajes.mapper.UserMapper;
import co.edu.icesiviajes.repository.UserRepository;
import co.edu.icesiviajes.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public UserDTO findByemail(String email) {
            User user = repository.findByLogin(email);
            return mapper.toUserDTO(user);
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

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getLogin(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getFirst_name(),
                userDTO.getLast_name(),
                userDTO.getNum_id(),
                "true"
        );
        repository.save(user);
        return user.getFirst_name();
    }
    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = repository.findByLogin(loginDTO.getEmail());
        System.out.println("encontro a "+user.getFirst_name());
        if (user != null){
            String password = loginDTO.getPassword();
            String encodePassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if (isPwdRight){
                Optional<User> user1 = repository.findByLoginAndPassword(loginDTO.getEmail(),encodePassword);
                if(user1.isPresent()) {
                    return new LoginResponse("Login Success", true);
                }else{
                    return new LoginResponse("Login Failed", false);
                }
            }else{
                return new LoginResponse("Password Not Match", false);
            }
        }else{
            return new LoginResponse("Email not exist", false);
        }
    }

    @Override
    public List<UserDTO> listAll(String word) {
        if (word != null && !word.trim().isEmpty()) {
            return mapper.toUserDTO(repository.listAll(word));
        } else {
            return mapper.toUserDTO(repository.findAll());
        }
    }

}
