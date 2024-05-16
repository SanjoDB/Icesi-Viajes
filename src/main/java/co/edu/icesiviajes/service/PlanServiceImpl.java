package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Plan;
import co.edu.icesiviajes.dto.PlanDTO;
import co.edu.icesiviajes.mapper.PlanMapper;
import co.edu.icesiviajes.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private PlanMapper planMapper;

    @Override
    public List<PlanDTO> findAll() {

        List<PlanDTO> lstCliente = planMapper.toPlanDTO(planRepository.findAll());

        return lstCliente;
    }

    @Override
    public PlanDTO findById(Integer id) throws Exception {
        try{
            Plan plan = planRepository.findById(id).get();
            return planMapper.toPlanDTO(plan);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public PlanDTO save(PlanDTO entity) throws Exception {

        Plan plan = planMapper.toPlan(entity);

        if(planRepository.findById(plan.getId_plan()).isEmpty()){
            return planMapper.toPlanDTO(planRepository.save(plan));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public PlanDTO update(PlanDTO entity) throws Exception {

        Plan plan = planMapper.toPlan(entity);

        if(planRepository.findById(plan.getId_plan()).isPresent()){
            return planMapper.toPlanDTO(planRepository.save(plan));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(PlanDTO entity) throws Exception {

        Plan plan = planMapper.toPlan(entity);

        if(planRepository.findById(plan.getId_plan()).isPresent()){
            planRepository.delete(plan);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            Plan plan = planRepository.findById(id).get();
            planRepository.deleteById(plan.getId_plan());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(PlanDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return planRepository.count();

    }

}
