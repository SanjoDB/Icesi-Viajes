package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.Plan_PlanDetailDTO;

import java.util.List;

public interface Plan_PlanDetailService extends GenericService<Plan_PlanDetailDTO, Integer>{

    List<Plan_PlanDetailDTO> findByPlanID(Integer id);

    List<Plan_PlanDetailDTO> findByPlanDetailID(Integer id);

    Plan_PlanDetailDTO findByPlanIDAndPlanDetailID(Integer planId, Integer planDeId);

    void deleteByPlanID(Integer id);

    void deleteByPlanDetailID(Integer id);

}