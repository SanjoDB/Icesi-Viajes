package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Plan_PlanDetail;
import co.edu.icesiviajes.dto.Plan_PlanDetailDTO;
import co.edu.icesiviajes.mapper.Plan_PlanDetailMapper;
import co.edu.icesiviajes.repository.Plan_PlanDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class Plan_PlanDetailServiceImpl implements Plan_PlanDetailService {

    @Autowired
    private Plan_PlanDetailRepository repository;
    @Autowired
    private Plan_PlanDetailMapper mapper;

    @Override
    public List<Plan_PlanDetailDTO> findAll() {

        List<Plan_PlanDetailDTO> lst = mapper.toPlan_PlanDetailDTO(repository.findAll());

        return lst;
    }

    @Override
    public Plan_PlanDetailDTO findById(Integer id) throws Exception {
        try{
            Plan_PlanDetail plan_PlanDetail = repository.findById(id).get();
            return mapper.toPlan_PlanDetailDTO(plan_PlanDetail);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public Plan_PlanDetailDTO save(Plan_PlanDetailDTO entity) throws Exception {

        if(repository.findById(entity.getId_pAd()).isEmpty()){
            Plan_PlanDetail plan_PlanDetail = mapper.toPlan_PlanDetail(entity);
            return mapper.toPlan_PlanDetailDTO(repository.save(plan_PlanDetail));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public Plan_PlanDetailDTO update(Plan_PlanDetailDTO entity) throws Exception {

        if(repository.findById(entity.getId_pAd()).isPresent()){
            Plan_PlanDetail plan_PlanDetail = mapper.toPlan_PlanDetail(entity);
            return mapper.toPlan_PlanDetailDTO(repository.save(plan_PlanDetail));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(Plan_PlanDetailDTO entity) throws Exception {

        if(repository.findById(entity.getId_pAd()).isPresent()){
            Plan_PlanDetail plan_PlanDetail = mapper.toPlan_PlanDetail(entity);
            repository.delete(plan_PlanDetail);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(Plan_PlanDetailDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

    @Override
    public List<Plan_PlanDetailDTO> findByPlanId_plan(Integer id) {

        List<Plan_PlanDetailDTO> lst = mapper.toPlan_PlanDetailDTO(repository.findByPlan_Id(id));

        return lst;

    }

    @Override
    public List<Plan_PlanDetailDTO> findByPlanDetailId_planDetail(Integer id) {

        List<Plan_PlanDetailDTO> lst = mapper.toPlan_PlanDetailDTO(repository.findByPlanDetail_Id(id));

        return lst;

    }


    public Plan_PlanDetailDTO findByPlanIDAndPlanDetailID(Integer planId, Integer planDeId) {

        Plan_PlanDetailDTO lst = mapper.toPlan_PlanDetailDTO(repository.findByPlan_IdAndPlanDetail_Id(planId, planDeId));

        return lst;

    }

    @Override
    public void deleteByPlanId_plan(Integer id) {

        repository.deleteByPlan_Id(id);

    }

    @Override
    public void deleteByPlanDetailId_planDetail(Integer id) {

        repository.deleteByPlanDetail_Id(id);

    }

}