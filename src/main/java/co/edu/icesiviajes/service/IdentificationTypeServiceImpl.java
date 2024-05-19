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
    private IdentificationTypeRepository identificationTypeRepository;
    @Autowired
    private IdentificationTypeMapper identificationTypeMapper;

    @Override
    public List<IdentificationTypeDTO> findAll() {

        List<IdentificationTypeDTO> lstIdentificationType = identificationTypeMapper.toIdentificationTypeDTO(identificationTypeRepository.findAll());

        return lstIdentificationType;
    }

    @Override
    public IdentificationTypeDTO findById(Integer id) throws Exception {
        try{
            IdentificationType identificationType = identificationTypeRepository.findById(id).get();
            return identificationTypeMapper.toIdentificationTypeDTO(identificationType);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public IdentificationTypeDTO save(IdentificationTypeDTO entity) throws Exception {

        IdentificationType identificationType = identificationTypeMapper.toIdentificationType(entity);

        if(identificationTypeRepository.findById(identificationType.getId_idty()).isEmpty()){
            return identificationTypeMapper.toIdentificationTypeDTO(identificationTypeRepository.save(identificationType));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public IdentificationTypeDTO update(IdentificationTypeDTO entity) throws Exception {

        IdentificationType identificationType = identificationTypeMapper.toIdentificationType(entity);

        if(identificationTypeRepository.findById(identificationType.getId_idty()).isPresent()){
            return identificationTypeMapper.toIdentificationTypeDTO(identificationTypeRepository.save(identificationType));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(IdentificationTypeDTO entity) throws Exception {

        IdentificationType identificationType = identificationTypeMapper.toIdentificationType(entity);

        if(identificationTypeRepository.findById(identificationType.getId_idty()).isPresent()){
            identificationTypeRepository.delete(identificationType);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            IdentificationType identificationType = identificationTypeRepository.findById(id).get();
            identificationTypeRepository.deleteById(identificationType.getId_idty());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(IdentificationTypeDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return identificationTypeRepository.count();

    }

}