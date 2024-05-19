package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Plan_Destination;
import co.edu.icesiviajes.dto.Plan_DestinationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface Plan_DestinationMapper {

    @Mapping(source = "destination.id_destination", target = "destination")
    @Mapping(source = "plan.id_plan", target = "plan")
    Plan_DestinationDTO toDestination_DestinationTypeDTO(Plan_Destination entity);

    @Mapping(source = "destination", target = "destination.id_destination")
    @Mapping(source = "plan", target = "plan.id_plan")
    Plan_Destination toDestination_DestinationType(Plan_DestinationDTO entity);

    @Mapping(source = "destination.id_destination", target = "destination")
    @Mapping(source = "plan.id_plan", target = "plan")
    List<Plan_DestinationDTO> toDestination_DestinationTypeDTO(List<Plan_Destination> entity);

    @Mapping(source = "destination", target = "destination.id_destination")
    @Mapping(source = "plan", target = "plan.id_plan")
    List<Plan_Destination> toDestination_DestinationType(List<Plan_DestinationDTO> entity);

}