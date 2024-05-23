package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Plan;
import co.edu.icesiviajes.dto.PlanDTO;

import java.util.List;

public interface PlanService extends GenericService<PlanDTO, Integer>{

    List<Plan> findAllPlans();

    List<PlanDTO> listAll(String word);

}
