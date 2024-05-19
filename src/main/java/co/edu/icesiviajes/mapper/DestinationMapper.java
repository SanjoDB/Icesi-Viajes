package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Destination;
import co.edu.icesiviajes.dto.DestinationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface DestinationMapper {

    DestinationDTO toDestinationDTO(Destination entity);

    Destination toDestination(DestinationDTO entity);

    List<DestinationDTO> toDestinationDTO(List<Destination> entity);

    List<Destination> toDestination(List<DestinationDTO> entity);

}
