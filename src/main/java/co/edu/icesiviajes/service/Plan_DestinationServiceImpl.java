package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Plan_Destination;
import co.edu.icesiviajes.dto.Plan_DestinationDTO;
import co.edu.icesiviajes.mapper.Plan_DestinationMapper;
import co.edu.icesiviajes.repository.Plan_DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class Plan_DestinationServiceImpl implements Plan_DestinationService {

    @Autowired
    private Plan_DestinationRepository repository;
    @Autowired
    private Plan_DestinationMapper mapper;

    @Override
    public List<Plan_DestinationDTO> findAll() {

        List<Plan_DestinationDTO> lst = mapper.toDestination_DestinationTypeDTO(repository.findAll());

        return lst;
    }

    @Override
    public Plan_DestinationDTO findById(Integer id) throws Exception {
        try{
            Plan_Destination plan_Destination = repository.findById(id).get();
            return mapper.toDestination_DestinationTypeDTO(plan_Destination);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public Plan_DestinationDTO save(Plan_DestinationDTO entity) throws Exception {
        if(repository.findById(entity.getId_pAdt()).isEmpty()){
            Plan_Destination plan_Destination = mapper.toDestination_DestinationType(entity);
            return mapper.toDestination_DestinationTypeDTO(repository.save(plan_Destination));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public Plan_DestinationDTO update(Plan_DestinationDTO entity) throws Exception {
        if(repository.findById(entity.getId_pAdt()).isPresent()){
            Plan_Destination plan_Destination = mapper.toDestination_DestinationType(entity);
            return mapper.toDestination_DestinationTypeDTO(repository.save(plan_Destination));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(Plan_DestinationDTO entity) throws Exception {
        if(repository.findById(entity.getId_pAdt()).isPresent()){
            Plan_Destination plan_Destination = mapper.toDestination_DestinationType(entity);
            repository.delete(plan_Destination);
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
    public void validate(Plan_DestinationDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

}
