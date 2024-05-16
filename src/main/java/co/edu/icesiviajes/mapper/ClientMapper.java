package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Client;
import co.edu.icesiviajes.dto.ClientDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientDTO toClientDTO(Client entity);

    Client toClient(ClientDTO entity);

    List<ClientDTO> toClientDTO(List<Client> entity);

    List<Client> toClient(List<ClientDTO> entity);

}
