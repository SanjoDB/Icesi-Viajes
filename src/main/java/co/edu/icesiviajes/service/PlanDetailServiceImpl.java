package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.PlanDetail;
import co.edu.icesiviajes.dto.PlanDetailDTO;
import co.edu.icesiviajes.mapper.PlanDetailMapper;
import co.edu.icesiviajes.repository.PlanDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class PlanDetailServiceImpl implements PlanDetailService {


    @Autowired
    private PlanDetailRepository repository;
    @Autowired
    private PlanDetailMapper mapper;

    @Override
    public List<PlanDetailDTO> findAll() {

        List<PlanDetailDTO> lst = mapper.toPlanDetailDTO(repository.findAll());

        return lst;
    }

    @Override
    public PlanDetailDTO findById(Integer id) throws Exception {
        try{
            PlanDetail plan = repository.findById(id).get();
            return mapper.toPlanDetailDTO(plan);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public PlanDetailDTO save(PlanDetailDTO entity) throws Exception {

        if(repository.findById(entity.getId_planDetail()).isEmpty()){
            PlanDetail plan = mapper.toPlanDetail(entity);
            return mapper.toPlanDetailDTO(repository.save(plan));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public PlanDetailDTO update(PlanDetailDTO entity) throws Exception {

        if(repository.findById(entity.getId_planDetail()).isPresent()){
            PlanDetail plan = mapper.toPlanDetail(entity);
            return mapper.toPlanDetailDTO(repository.save(plan));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(PlanDetailDTO entity) throws Exception {

        if(repository.findById(entity.getId_planDetail()).isPresent()){
            PlanDetail plan = mapper.toPlanDetail(entity);
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
    public void validate(PlanDetailDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

}