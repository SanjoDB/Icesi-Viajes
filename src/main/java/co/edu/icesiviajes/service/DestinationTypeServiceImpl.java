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
    private DestinationTypeRepository destinationTypeRepository;
    @Autowired
    private DestinationTypeMapper destinationTypeMapper;

    @Override
    public List<DestinationTypeDTO> findAll() {

        List<DestinationTypeDTO> lstCliente = destinationTypeMapper.toDestinationTypeDTO(destinationTypeRepository.findAll());

        return lstCliente;
    }

    @Override
    public DestinationTypeDTO findById(Integer id) throws Exception {
        try{
            DestinationType destinationType = destinationTypeRepository.findById(id).get();
            return destinationTypeMapper.toDestinationTypeDTO(destinationType);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public DestinationTypeDTO save(DestinationTypeDTO entity) throws Exception {

        DestinationType destinationType = destinationTypeMapper.toDestinationType(entity);

        if(destinationTypeRepository.findById(destinationType.getIdDesType()).isEmpty()){
            return destinationTypeMapper.toDestinationTypeDTO(destinationTypeRepository.save(destinationType));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public DestinationTypeDTO update(DestinationTypeDTO entity) throws Exception {

        DestinationType destinationType = destinationTypeMapper.toDestinationType(entity);

        if(destinationTypeRepository.findById(destinationType.getIdDesType()).isPresent()){
            return destinationTypeMapper.toDestinationTypeDTO(destinationTypeRepository.save(destinationType));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(DestinationTypeDTO entity) throws Exception {

        DestinationType destinationType = destinationTypeMapper.toDestinationType(entity);

        if(destinationTypeRepository.findById(destinationType.getIdDesType()).isPresent()){
            destinationTypeRepository.delete(destinationType);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            DestinationType destinationType = destinationTypeRepository.findById(id).get();
            destinationTypeRepository.deleteById(destinationType.getIdDesType());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(DestinationTypeDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return destinationTypeRepository.count();

    }

}
