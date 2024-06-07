package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Plan;
import co.edu.icesiviajes.dto.PlanDTO;
import co.edu.icesiviajes.mapper.PlanMapper;
import co.edu.icesiviajes.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@Scope("singleton")
@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanRepository repository;
    @Autowired
    private PlanMapper mapper;

    @Override
    public List<PlanDTO> findAll() {

        List<PlanDTO> lst = mapper.toPlanDTO(repository.findAll());

        return lst;
    }

    @Override
    public PlanDTO findById(Integer id) throws Exception {
        try{
            Plan plan = repository.findById(id).get();
            System.out.println(plan.getName());
            return mapper.toPlanDTO(plan);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public PlanDTO save(PlanDTO entity) throws Exception {

        if(repository.findById(entity.getId_plan()).isEmpty()){

            Plan plan = mapper.toPlan(entity);
            return mapper.toPlanDTO(repository.save(plan));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public PlanDTO update(PlanDTO entity) throws Exception {
        if(repository.findById(entity.getId_plan()).isPresent()){
            Plan plan = mapper.toPlan(entity);
            plan.setCode(entity.getCode());
            plan.setName(entity.getName());
            plan.setDescription(entity.getDescription());
            plan.setPrice(entity.getPrice());
            plan.setNum_people(entity.getNum_people());
            plan.setStart_Date(entity.getStart_Date());
            plan.setEnd_Date(entity.getEnd_Date());
            plan.setImage(entity.getImage());
            plan.setState(entity.getState());


            return mapper.toPlanDTO(repository.save(plan));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(PlanDTO entity) throws Exception {

        if(repository.findById(entity.getId_plan()).isPresent()){
            Plan plan = mapper.toPlan(entity);
            repository.delete(plan);
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
    public void validate(PlanDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

    @Override
    public List<PlanDTO> listAll(String word) {
        if (word != null && !word.trim().isEmpty()) {
            return mapper.toPlanDTO(repository.listAll(word));
        } else {
            return mapper.toPlanDTO(repository.findAll());
        }
    }

}