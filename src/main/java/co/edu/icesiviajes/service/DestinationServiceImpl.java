package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Destination;
import co.edu.icesiviajes.dto.DestinationDTO;
import co.edu.icesiviajes.mapper.DestinationMapper;
import co.edu.icesiviajes.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class DestinationServiceImpl implements DestinationService{

    @Autowired
    private DestinationRepository repository;
    @Autowired
    private DestinationMapper mapper;

    @Override
    public List<DestinationDTO> findAll() {

        List<DestinationDTO> lst = mapper.toDestinationDTO(repository.findAll());

        return lst;
    }

    @Override
    public DestinationDTO findById(Integer id) throws Exception {
        try{
            Destination destination = repository.findById(id).get();
            return mapper.toDestinationDTO(destination);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public DestinationDTO save(DestinationDTO entity) throws Exception {

        if(repository.findById(entity.getId_destination()).isEmpty()){
            Destination destination = mapper.toDestination(entity);
            return mapper.toDestinationDTO(repository.save(destination));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public DestinationDTO update(DestinationDTO entity) throws Exception {

        if(repository.findById(entity.getId_destination()).isPresent()){
            Destination destination = mapper.toDestination(entity);
            return mapper.toDestinationDTO(repository.save(destination));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(DestinationDTO entity) throws Exception {

        if(repository.findById(entity.getId_destination()).isPresent()){
            Destination destination = mapper.toDestination(entity);
            repository.delete(destination);
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
    public void validate(DestinationDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

}
