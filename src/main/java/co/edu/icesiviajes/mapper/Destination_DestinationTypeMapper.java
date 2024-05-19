package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Destination_DestinationType;
import co.edu.icesiviajes.dto.Destination_DestinationTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface Destination_DestinationTypeMapper {

    @Mapping(source = "destination.id_destination", target = "destination")
    @Mapping(source = "destinationType.id_desType", target = "destinationType")
    Destination_DestinationTypeDTO toDestination_DestinationTypeDTO(Destination_DestinationType entity);

    @Mapping(source = "destination", target = "destination.id_destination")
    @Mapping(source = "destinationType", target = "destinationType.id_desType")
    Destination_DestinationType toDestination_DestinationType(Destination_DestinationTypeDTO entity);

    @Mapping(source = "destination.id_destination", target = "destination")
    @Mapping(source = "destinationType.id_desType", target = "destinationType")
    List<Destination_DestinationTypeDTO> toDestination_DestinationTypeDTO(List<Destination_DestinationType> entity);

    @Mapping(source = "destination", target = "destination.id_destination")
    @Mapping(source = "destinationType", target = "destinationType.id_desType")
    List<Destination_DestinationType> toDestination_DestinationType(List<Destination_DestinationTypeDTO> entity);

}
