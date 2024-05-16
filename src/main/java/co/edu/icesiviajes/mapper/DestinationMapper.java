package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Destination;
import co.edu.icesiviajes.dto.DestinationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface DestinationMapper {

    @Mapping(source = "destinationType.idDesType", target = "destinationType")
    DestinationDTO toDestinationDTO(Destination entity);

    @Mapping(source = "destinationType", target = "destinationType.idDesType")
    Destination toDestination(DestinationDTO entity);

    @Mapping(source = "destinationType.idDesType", target = "destinationType")
    List<DestinationDTO> toDestinationDTO(List<Destination> entity);

    @Mapping(source = "destinationType", target = "destinationType.idDesType")
    List<Destination> toDestination(List<DestinationDTO> entity);

}
