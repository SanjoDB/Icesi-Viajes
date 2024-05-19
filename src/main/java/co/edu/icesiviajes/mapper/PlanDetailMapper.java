package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.PlanDetail;
import co.edu.icesiviajes.dto.PlanDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PlanDetailMapper {

    @Mapping(source = "destination.id_destination", target = "destination")
    PlanDetailDTO toPlanDetailDTO(PlanDetail entity);

    @Mapping(source = "destination", target = "destination.id_destination")
    PlanDetail toPlanDetail(PlanDetailDTO entity);

    @Mapping(source = "destination.id_destination", target = "destination")
    List<PlanDetailDTO> toPlanDetailDTO(List<PlanDetail> entity);

    @Mapping(source = "destination", target = "destination.id_destination")
    List<PlanDetail> toPlanDetail(List<PlanDetailDTO> entity);

}
