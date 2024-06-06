package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.Plan_PlanDetailDTO;

import java.util.List;

public interface Plan_PlanDetailService extends GenericService<Plan_PlanDetailDTO, Integer>{

    List<Plan_PlanDetailDTO> findByPlanId_plan(Integer id);

    List<Plan_PlanDetailDTO> findByPlanDetailId_planDetail(Integer id);


    void deleteByPlanId_plan(Integer id);

    void deleteByPlanDetailId_planDetail(Integer id);

}