package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.DestinationType;
import co.edu.icesiviajes.dto.DestinationTypeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DestinationTypeMapper {

    DestinationTypeDTO toDestinationTypeDTO(DestinationType entity);

    DestinationType toDestinationType(DestinationTypeDTO entity);

    List<DestinationTypeDTO> toDestinationTypeDTO(List<DestinationType> entity);

    List<DestinationType> toDestinationType(List<DestinationTypeDTO> entity);

}
