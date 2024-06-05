package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Destination_DestinationType;
import co.edu.icesiviajes.dto.Destination_DestinationTypeDTO;
import co.edu.icesiviajes.mapper.Destination_DestinationTypeMapper;
import co.edu.icesiviajes.repository.Destination_DestinationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class Destination_DestinationTypeServiceImpl implements Destination_DestinationTypeService {

    @Autowired
    private Destination_DestinationTypeRepository repository;
    @Autowired
    private Destination_DestinationTypeMapper mapper;

    @Override
    public List<Destination_DestinationTypeDTO> findAll() {

        List<Destination_DestinationTypeDTO> lst = mapper.toDestination_DestinationTypeDTO(repository.findAll());

        return lst;
    }

    @Override
    public Destination_DestinationTypeDTO findById(Integer id) throws Exception {
        try{
            Destination_DestinationType destination_DestinationType = repository.findById(id).get();
            return mapper.toDestination_DestinationTypeDTO(destination_DestinationType);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public Destination_DestinationTypeDTO save(Destination_DestinationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getId_dAt()).isEmpty()){
            Destination_DestinationType destination_DestinationType = mapper.toDestination_DestinationType(entity);
            return mapper.toDestination_DestinationTypeDTO(repository.save(destination_DestinationType));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public Destination_DestinationTypeDTO update(Destination_DestinationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getId_dAt()).isPresent()){
            Destination_DestinationType destination_DestinationType = mapper.toDestination_DestinationType(entity);
            return mapper.toDestination_DestinationTypeDTO(repository.save(destination_DestinationType));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(Destination_DestinationTypeDTO entity) throws Exception {
        if(repository.findById(entity.getId_dAt()).isPresent()){
            Destination_DestinationType destination_DestinationType = mapper.toDestination_DestinationType(entity);
            repository.delete(destination_DestinationType);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(Destination_DestinationTypeDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

    @Override
    public List<Destination_DestinationTypeDTO> findByDestinationID(Integer id) {

        List<Destination_DestinationTypeDTO> lst = mapper.toDestination_DestinationTypeDTO(repository.findByDestinationID(id));

        return lst;

    }

    @Override
    public List<Destination_DestinationTypeDTO> findByDestinationTypeID(Integer id) {

        List<Destination_DestinationTypeDTO> lst = mapper.toDestination_DestinationTypeDTO(repository.findByDestinationTypeID(id));

        return lst;

    }

    @Override
    public Destination_DestinationTypeDTO findByDestinationIDAndDestinatioTypeID(Integer desId, Integer desTyId) {

        Destination_DestinationTypeDTO lst = mapper.toDestination_DestinationTypeDTO(repository.findByDestinationIDAndDestinatioTypeID(desId, desTyId));

        return lst;

    }

    @Override
    public void deleteByDestinationID(Integer id) {

        repository.deleteByDestinationID(id);

    }

    @Override
    public void deleteByDestinationTypeID(Integer id) {

        repository.deleteByDestinationTypeID(id);

    }

}