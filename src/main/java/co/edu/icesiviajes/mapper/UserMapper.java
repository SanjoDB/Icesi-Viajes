package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.User;
import co.edu.icesiviajes.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDTO toUserDTO(User entity);

    User toUser(UserDTO entity);

    List<UserDTO> toUserDTO(List<User> entity);

    List<User> toUser(List<UserDTO> entity);

}
