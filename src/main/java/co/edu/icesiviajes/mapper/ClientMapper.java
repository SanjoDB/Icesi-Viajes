package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Client;
import co.edu.icesiviajes.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Mapping(source = "identificationType.id_idty", target = "identificationType")
    ClientDTO toClientDTO(Client entity);

    @Mapping(source = "identificationType", target = "identificationType.id_idty")
    Client toClient(ClientDTO entity);

    @Mapping(source = "identificationType.id_idty", target = "identificationType")
    List<ClientDTO> toClientDTO(List<Client> entity);

    @Mapping(source = "identificationType", target = "identificationType.id_idty")
    List<Client> toClient(List<ClientDTO> entity);

}
