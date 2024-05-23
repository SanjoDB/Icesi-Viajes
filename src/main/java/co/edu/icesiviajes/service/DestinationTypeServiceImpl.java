package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.DestinationType;
import co.edu.icesiviajes.dto.DestinationTypeDTO;
import co.edu.icesiviajes.mapper.DestinationTypeMapper;
import co.edu.icesiviajes.repository.DestinationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class DestinationTypeServiceImpl implements DestinationTypeService{

    @Autowired
    private DestinationTypeRepository repository;
    @Autowired
    private DestinationTypeMapper mapper;

    @Override
    public List<DestinationTypeDTO> findAll() {

        List<DestinationTypeDTO> lst = mapper.toDestinationTypeDTO(repository.findAll());

        return lst;
    }

    @Override
    public DestinationTypeDTO findById(Integer id) throws Exception {
        try{
            DestinationType destinationType = repository.findById(id).get();
            return mapper.toDestinationTypeDTO(destinationType);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public DestinationTypeDTO save(DestinationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getIdDesType()).isEmpty()){
            DestinationType destinationType = mapper.toDestinationType(entity);
            return mapper.toDestinationTypeDTO(repository.save(destinationType));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public DestinationTypeDTO update(DestinationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getIdDesType()).isPresent()){
            DestinationType destinationType = mapper.toDestinationType(entity);
            return mapper.toDestinationTypeDTO(repository.save(destinationType));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(DestinationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getIdDesType()).isPresent()){
            DestinationType destinationType = mapper.toDestinationType(entity);
            repository.delete(destinationType);
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
    public void validate(DestinationTypeDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

}
