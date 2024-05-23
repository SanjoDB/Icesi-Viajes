package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.IdentificationType;
import co.edu.icesiviajes.dto.IdentificationTypeDTO;
import co.edu.icesiviajes.mapper.IdentificationTypeMapper;
import co.edu.icesiviajes.repository.IdentificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class IdentificationTypeServiceImpl implements IdentificationTypeService{

    @Autowired
    private IdentificationTypeRepository repository;
    @Autowired
    private IdentificationTypeMapper mapper;

    @Override
    public List<IdentificationTypeDTO> findAll() {

        List<IdentificationTypeDTO> lst = mapper.toIdentificationTypeDTO(repository.findAll());

        return lst;
    }

    @Override
    public IdentificationTypeDTO findById(Integer id) throws Exception {
        try{
            IdentificationType identificationType = repository.findById(id).get();
            return mapper.toIdentificationTypeDTO(identificationType);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public IdentificationTypeDTO save(IdentificationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getId_idty()).isEmpty()){
            IdentificationType identificationType = mapper.toIdentificationType(entity);
            return mapper.toIdentificationTypeDTO(repository.save(identificationType));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public IdentificationTypeDTO update(IdentificationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getId_idty()).isPresent()){
            IdentificationType identificationType = mapper.toIdentificationType(entity);
            return mapper.toIdentificationTypeDTO(repository.save(identificationType));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(IdentificationTypeDTO entity) throws Exception {

        if(repository.findById(entity.getId_idty()).isPresent()){
            IdentificationType identificationType = mapper.toIdentificationType(entity);
            repository.delete(identificationType);
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
    public void validate(IdentificationTypeDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

}