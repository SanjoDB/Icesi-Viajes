package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Plan_PlanDetail;
import co.edu.icesiviajes.dto.Plan_PlanDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface Plan_PlanDetailMapper {

    @Mapping(source = "plan.id_plan", target = "plan")
    @Mapping(source = "planDetail.id_planDetail", target = "planDetail")
    Plan_PlanDetailDTO toDestination_DestinationTypeDTO(Plan_PlanDetail entity);

    @Mapping(source = "plan", target = "plan.id_plan")
    @Mapping(source = "planDetail", target = "planDetail.id_planDetail")
    Plan_PlanDetail toDestination_DestinationType(Plan_PlanDetailDTO entity);

    @Mapping(source = "plan.id_plan", target = "plan")
    @Mapping(source = "planDetail.id_planDetail", target = "planDetail")
    List<Plan_PlanDetailDTO> toDestination_DestinationTypeDTO(List<Plan_PlanDetail> entity);

    @Mapping(source = "plan", target = "plan.id_plan")
    @Mapping(source = "planDetail", target = "planDetail.id_planDetail")
    List<Plan_PlanDetail> toDestination_DestinationType(List<Plan_PlanDetailDTO> entity);

}
