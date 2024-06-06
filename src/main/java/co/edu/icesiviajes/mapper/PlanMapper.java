package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Plan;
import co.edu.icesiviajes.dto.PlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PlanMapper {


    @Mapping(source = "user.id_user", target = "user")
    PlanDTO toPlanDTO(Plan entity);


    @Mapping(source = "user", target = "user.id_user")
    Plan toPlan(PlanDTO entity);


    @Mapping(source = "user.id_user", target = "user")
    List<PlanDTO> toPlanDTO(List<Plan> entity);

    @Mapping(source = "user", target = "user.id_user")
    List<Plan> toPlan(List<PlanDTO> entity);

}
